import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * gui for admin menu form
 * @author kashefi
 * @version 0.0
 */
public class AdminMenu extends Menu {
    private JButton weeklyMealBtn;
    private JButton addClassBtn;
    private JButton classesInfoBtn;
    private JButton addStudentBtn;
    private JButton addProfessorBtn;
    private JButton listOfStudents;
    private JButton listOfProfessors;
    private JButton listOfClasses;

    private IProfessorService professorService;

    AdminMenu(String username) {
        super(username, "Admin Menu", 11, 420);
        professorService = new ProfessorService();
        addStudentBtn = new JButton(" ADD STUDENT ");
        addProfessorBtn = new JButton(" ADD PROFESSOR ");
        weeklyMealBtn = new JButton(" Weekly Meal Plan ");
        addClassBtn = new JButton(" Add Course ");
        classesInfoBtn = new JButton(" Professor Info ");
        listOfProfessors = new JButton(" List of Professors ");
        listOfStudents = new JButton(" List of Students ");
        listOfClasses = new JButton(" List of Classes ");
        addStudentBtn.addActionListener(this);
        weeklyMealBtn.addActionListener(this);
        addClassBtn.addActionListener(this);
        classesInfoBtn.addActionListener(this);
        addProfessorBtn.addActionListener(this);
        listOfStudents.addActionListener(this);
        listOfProfessors.addActionListener(this);
        listOfClasses.addActionListener(this);
        this.panel.add(addStudentBtn);
        this.panel.add(addProfessorBtn);
        this.panel.add(weeklyMealBtn);
        this.panel.add(addClassBtn);
        this.panel.add(classesInfoBtn);
        this.panel.add(listOfProfessors);
        this.panel.add(listOfStudents);
        this.panel.add(listOfClasses);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signOutBtn) {
            new LoginForm();
            dispose();
        } else if (e.getSource() == addStudentBtn) {
            new AddStudentForm();
        } else if (e.getSource() == addProfessorBtn) {
            new AddProfessorForm();
        } else if (e.getSource() == changeUsernameBtn) {
            new ChangeUsernameForm(getUsername());
        } else if (e.getSource() == changePasswordBtn) {
            new ChangePasswordForm(getUsername());
        } else if (e.getSource() == weeklyMealBtn) {
            new WeeklyMealPlanFormForAdmin();
        } else if (e.getSource() == addClassBtn) {
            List<Professor> professors = professorService.getProfessors();
            if (professors != null && professors.size() > 0) {
                new AddProfessorClassForm();
            } else {
                JOptionPane.showMessageDialog(this, "any professor does not exist, Please add professor first");
            }
        } else if (e.getSource() == classesInfoBtn) {
            new ProfessorInfoForm();
        } else if (e.getSource() == listOfProfessors) {
            new ProfessorsForm();
        } else if (e.getSource() == listOfStudents) {
            new StudentsForm();
        } else if (e.getSource() == listOfClasses) {
            new ClassesForm();
        }

    }
}

