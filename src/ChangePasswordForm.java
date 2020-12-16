import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ChangePasswordForm extends JFrame {
    private JPanel panel;
    private JLabel userLabel, PassLabel, confirmPassLabel, message;
    private JTextField userNameText;
    private JPasswordField newPassword;
    private JPasswordField confirmPassword;

    private JButton applyBtn, cancelBtn;
    private String currentUsername;

    ChangePasswordForm(String username) {
        userLabel = new JLabel();
        userLabel.setText(" Old Username ");
        userNameText = new JTextField(username);
        userNameText.setEditable(false);
        currentUsername = username;
        userNameText.setHorizontalAlignment(SwingConstants.CENTER);
        PassLabel = new JLabel();
        PassLabel.setText(" New Password ");
        confirmPassLabel = new JLabel();
        confirmPassLabel.setText(" Confirm New Password ");
        newPassword = new JPasswordField();
        newPassword.setHorizontalAlignment(SwingConstants.CENTER);
        confirmPassword = new JPasswordField();
        confirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
        applyBtn = new JButton(" Apply ");
        cancelBtn = new JButton(" Cancel ");
        GridLayout gridLayout = new GridLayout(5, 2);
        gridLayout.setVgap(10);
        panel = new JPanel(gridLayout);
        panel.add(userLabel);
        panel.add(userNameText);
        panel.add(PassLabel);
        panel.add(newPassword);
        panel.add(confirmPassLabel);
        panel.add(confirmPassword);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.add(new JLabel());
        panel.add(applyBtn);
        panel.add(new JLabel());
        panel.add(cancelBtn);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(panel, BorderLayout.CENTER);
        setTitle("CHANGE USERNAME");
        setSize(450, 200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setVisible(true);
    }

}