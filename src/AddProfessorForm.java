import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * gui for adding professor form
 * @author kashefi
 * @version 0.0
 */
public class AddProfessorForm extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel label, PassLabel;
    private JTextField userNameTxt;
    private JPasswordField passwordTxt;
    private JButton applyBtn, cancelBtn;
    private IAccountService accountService;

    AddProfessorForm() {
        accountService = new AccountService();
        label = new JLabel();
        label.setText(" Professor Username ");
        userNameTxt = new JTextField();
        userNameTxt.setHorizontalAlignment(SwingConstants.CENTER);
        PassLabel = new JLabel();
        PassLabel.setText(" Professor Password ");
        passwordTxt = new JPasswordField();
        passwordTxt.setHorizontalAlignment(SwingConstants.CENTER);
        applyBtn = new JButton(" Apply ");
        cancelBtn = new JButton(" Cancel ");
        GridLayout gridLayout = new GridLayout(4, 2);
        gridLayout.setVgap(10);
        panel = new JPanel(gridLayout);
        panel.add(label);
        panel.add(userNameTxt);
        panel.add(PassLabel);
        panel.add(passwordTxt);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.add(new JLabel());
        panel.add(applyBtn);
        panel.add(new JLabel());
        panel.add(cancelBtn);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        applyBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("ADD PROFESSOR");
        setSize(450, 200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String password = passwordTxt.getText().trim();
        String username = userNameTxt.getText().trim();
        if (ae.getSource() == applyBtn) {
            if (username == null || password == null || username.length() <= 0 || password.length() <= 0) {
                JOptionPane.showMessageDialog(this, "Please fill input fields");
            } else if (accountService.isDuplicateUsername(username)) {
                JOptionPane.showMessageDialog(this, "Username is duplicated");
            } else if (!accountService.isValidPassword(password)) {
                JOptionPane.showMessageDialog(this, "Password must be at least 8 characters");
            } else {
                accountService.addUser(username, password, UserRole.Professor);
                passwordTxt.setText("");
                userNameTxt.setText("");
                accountService.printUsers();
                JOptionPane.showMessageDialog(this, "New Professor is successfully added");
            }
        } else if (ae.getSource() == cancelBtn) {
            dispose();
        }


    }

}

