import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LoginForm extends JFrame implements ActionListener {
    JPanel panel;
    JLabel userLabel, PassLabel, message;
    JTextField userNameText;
    JPasswordField passwordText;
    JButton login, cancel;

    LoginForm() {
        userLabel = new JLabel();
        userLabel.setText(" Username ");
        userNameText = new JTextField();
        userNameText.setHorizontalAlignment(SwingConstants.CENTER);
        PassLabel = new JLabel();
        PassLabel.setText(" Password ");
        passwordText = new JPasswordField();
        passwordText.setHorizontalAlignment(SwingConstants.CENTER);
        login = new JButton(" Login ");
        GridLayout gridLayout = new GridLayout(3, 2);
        gridLayout.setVgap(10);
        panel = new JPanel(gridLayout);
        panel.add(userLabel);
        panel.add(userNameText);
        panel.add(PassLabel);
        panel.add(passwordText);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        message = new JLabel();
        panel.add(message);
        panel.add(login);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("LOGIN");
        setSize(450, 200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Menu menu = showMenuByUserRole();
    }

    private Menu showMenuByUserRole() {
        try {
            String userName = userNameText.getText();
            String password = passwordText.getText();
            if (isLogin(userName, password)) {
                User user = getUser(userName, password);
                Menu menu = null;
                if (user.getUserRole() == UserRole.Admin) {
                    menu = new AdminMenu(userName);
                    dispose();
                } else if (user.getUserRole() == UserRole.Professor) {
                    menu = new ProfessorMenu(userName);
                    dispose();
                } else if (user.getUserRole() == UserRole.Student) {
                    menu = new StudentMenu(userName);
                    dispose();
                }
                return menu;
            } else {
                JOptionPane.showMessageDialog(this, "username or password is incorrect");
            }
        } catch (Exception ex) {
            System.err.println(ex.getStackTrace());
        }
        return null;
    }


    private User getUser(String username, String password) {
        if (username.equalsIgnoreCase(AdminUserSample.getUsername())) {
            return AdminUserSample;
        } else if (username.equalsIgnoreCase(StudentUserSample.getUsername())) {
            return StudentUserSample;
        } else if (username.equalsIgnoreCase(ProfessorUserSample.getUsername())) {
            return ProfessorUserSample;
        }
        return null;
    }

    public boolean isLogin(String username, String password) {
        if (username.equalsIgnoreCase(AdminUserSample.getUsername())) {
            return password.equals(AdminUserSample.getPassword());
        } else if (username.equalsIgnoreCase(StudentUserSample.getUsername())) {
            return password.equals(StudentUserSample.getPassword());
        } else if (username.equalsIgnoreCase(ProfessorUserSample.getUsername())) {
            return password.equals(ProfessorUserSample.getPassword());
        }
        return false;
    }

    public User AdminUserSample = new User(1, "admin", "admin", UserRole.Admin);
    public User ProfessorUserSample = new User(2, "prof", "prof", UserRole.Professor);
    public User StudentUserSample = new User(3, "std", "std", UserRole.Student);

}