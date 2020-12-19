import javax.swing.*;
import java.awt.event.ActionEvent;

public class StudentMenu extends Menu {
    private JButton weeklyMealBtn;

    StudentMenu(String username) {
        super(username, "Student Menu", 4, 200);
        weeklyMealBtn = new JButton(" Weekly Meal Plan ");
        weeklyMealBtn.addActionListener(this);
        this.panel.add(weeklyMealBtn);
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
        } else if (e.getSource() == weeklyMealBtn) {
            new WeeklyMealPlanFormForStudent();
        }
    }
}


