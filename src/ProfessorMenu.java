import javax.swing.*;
import java.awt.event.ActionEvent;

public class ProfessorMenu extends Menu {

    private JButton addClassTimeBtn;
    private JButton allStudentsBtn;
    private JButton classStudentsInfoBtn;
    private JButton gradinBtn;

    ProfessorMenu(String username) {
        super(username, "Professor Menu", 7, 400);
        addClassTimeBtn = new JButton("Add Class");
        addClassTimeBtn.addActionListener(this);
        allStudentsBtn = new JButton("All Students");
        allStudentsBtn.addActionListener(this);
        classStudentsInfoBtn = new JButton("Students Info Per Class");
        classStudentsInfoBtn.addActionListener(this);
        gradinBtn = new JButton("Grading to Student");
        gradinBtn.addActionListener(this);
        this.panel.add(addClassTimeBtn);
        this.panel.add(allStudentsBtn);
        this.panel.add(classStudentsInfoBtn);
        this.panel.add(gradinBtn);
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
        } else if (e.getSource() == addClassTimeBtn) {
            new AddClassTimeForm();
        } else if (e.getSource() == allStudentsBtn) {
            new AllStudentsForm();
        } else if (e.getSource() == classStudentsInfoBtn) {
            new ClassStudentsInfo();
        } else if (e.getSource() == gradinBtn) {
            new GradingForm();
        }
    }
}
