import java.awt.event.ActionEvent;

public class AdminMenu extends Menu {

    AdminMenu(String username) {
        super(username, "Admin Menu", 6, 350);
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signOutBtn) {
            new LoginForm();
            dispose();
        } else if (e.getSource() == changeUsernameBtn) {
            new ChangeUsernameForm(getUsername());
        } else if (e.getSource() == changePasswordBtn) {
            new ChangePasswordForm(getUsername());
        }
    }
}

