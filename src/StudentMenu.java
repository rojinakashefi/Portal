import javax.swing.*;
import java.awt.event.ActionEvent;

public class StudentMenu extends Menu {
    private JPanel panel;
    private JButton changeUsername;

    StudentMenu(String username) {
        super(username, "Student Menu");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signOutBtn) {
            new LoginForm();
            dispose();
        } else if (e.getSource() == changeUsernameBtn) {
           // new ChangeUsernameForm(getUsername());
        } else if (e.getSource() == changePasswordBtn) {
           // new ChangePasswordForm(getUsername());
        }
    }
}


