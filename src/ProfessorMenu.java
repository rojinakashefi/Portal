import javax.swing.*;
import java.awt.event.ActionEvent;
/**
 * menu for professor it contains add class, all student, ...
 *  @author kashefi
 *  @version 0.0
 *
 */
public class ProfessorMenu extends Menu {

    private JButton addClassTimeBtn;
    private JButton allStudentsBtn;
    private JButton classStudentsInfoBtn;
    private JButton gradinBtn;
    private JButton closeBtn;


    ProfessorMenu(String username) {
        super(username, "Professor Menu", 8, 440);
        addClassTimeBtn = new JButton("Add Class");
        addClassTimeBtn.addActionListener(this);
        allStudentsBtn = new JButton("All Students");
        allStudentsBtn.addActionListener(this);
        classStudentsInfoBtn = new JButton("Students Info Per Class");
        classStudentsInfoBtn.addActionListener(this);
        gradinBtn = new JButton("Grading to Student");
        gradinBtn.addActionListener(this);
        closeBtn = new JButton("Close a Class");
        closeBtn.addActionListener(this);
        this.panel.add(addClassTimeBtn);
        this.panel.add(allStudentsBtn);
        this.panel.add(classStudentsInfoBtn);
        this.panel.add(gradinBtn);
        this.panel.add(closeBtn);
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
        }else if (e.getSource() == closeBtn) {
            new CloseClass();
        }
    }
}
