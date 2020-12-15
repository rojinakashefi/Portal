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
        login.addActionListener(this);
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
        add(panel, BorderLayout.CENTER);
        setTitle("LOGIN");
        setSize(450,200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String userName = userNameText.getText();
        String password = passwordText.getText();
        if (userName.trim().equals("admin") && password.trim().equals("admin")) {
            message.setText(" Hello " + userName + "");
        } else {
            message.setText(" Invalid user.. ");
        }
    }

}