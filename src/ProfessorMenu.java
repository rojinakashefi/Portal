import java.awt.event.ActionEvent;

public class ProfessorMenu extends Menu{

    ProfessorMenu(String username) {
        super(username,"Professor Menu");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signOutBtn){
            new LoginForm();
            dispose();
        } else if (e.getSource() == changeUsernameBtn) {
           // new ChangeUsernameForm(getUsername());
        } else if (e.getSource() == changePasswordBtn) {
           // new ChangePasswordForm(getUsername());
        }
    }
}
