import javax.swing.*;
import java.awt.event.ActionEvent;

public class AdminMenu extends Menu {
    private JButton weeklyMealBtn;
    private JButton addProfessorBtn;
    private JButton professorInfoBtn;

    AdminMenu(String username) {
        super(username, "Admin Menu", 6, 350);
        
        weeklyMealBtn = new JButton(" Weekly Meal Plan ");
        addProfessorBtn = new JButton(" Add Professor ");
        professorInfoBtn = new JButton(" Professor Info ");
        weeklyMealBtn.addActionListener(this);
        addProfessorBtn.addActionListener(this);
        professorInfoBtn.addActionListener(this);
        this.panel.add(weeklyMealBtn);
        this.panel.add(addProfessorBtn);
        this.panel.add(professorInfoBtn);
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
            new WeeklyMealPlanFormForAdmin();
        } else if (e.getSource() == addProfessorBtn) {
            new AddProfessorClassForm();
        } else if (e.getSource() == professorInfoBtn) {
            new ProfessorInfoForm();
        }
    }
}

