import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * gui form for student it contains adding credit, ...
 * @author kashefi
 * @version 0.0
 */
public class StudentMenu extends Menu {
    private JButton addCreditBtn;
    private JButton weeklyMealBtn;
    private JButton selectClass;
    private JButton selectedClassesBtn;

    StudentMenu(String username) {
        super(username, "Student Menu", 7, 360);
        weeklyMealBtn = new JButton(" Weekly Meal Plan ");
        weeklyMealBtn.addActionListener(this);
        addCreditBtn = new JButton(" Add Credit ");
        addCreditBtn.addActionListener(this);
        selectClass = new JButton(" Select Class ");
        selectClass.addActionListener(this);
        selectedClassesBtn = new JButton(" List of Selected Classes ");
        selectedClassesBtn.addActionListener(this);

        this.panel.add(weeklyMealBtn);
        this.panel.add(addCreditBtn);
        this.panel.add(selectClass);
        this.panel.add(selectedClassesBtn);
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
        } else if (e.getSource() == addCreditBtn) {
            new AddCreditForm();
        } else if (e.getSource() == selectClass) {
            new SelectCourseForm();
        } else if (e.getSource() == selectedClassesBtn) {
            new ListOfSelectedClassesForStudentForm();
        }
    }
}


