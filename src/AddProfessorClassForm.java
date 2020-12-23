import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AddProfessorClassForm extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel label, CourseNameLabel, unit;
    private JComboBox professorNameCombo;
    private JTextField teacherCourseNameTxt;
    private JSpinner unitNumber;
    private JButton applyBtn, cancelBtn;
    private ICourseService courseService;
    private IProfessorService professorService;

    AddProfessorClassForm() {
        courseService = new CourseService();
        professorService = new ProfessorService();
        label = new JLabel();
        label.setText(" Select Professor ");
        professorNameCombo = new JComboBox();
        List<Professor> professors = professorService.getProfessors();
        for (int i = 0; i < professors.size(); i++) {
            Professor professor = professors.get(i);
            professorNameCombo.addItem(professor.getUserName());
        }
        CourseNameLabel = new JLabel();
        CourseNameLabel.setText(" Course Name ");
        unit = new JLabel();
        unit.setText(" Units ");
        teacherCourseNameTxt = new JTextField();
        teacherCourseNameTxt.setHorizontalAlignment(SwingConstants.CENTER);
        unitNumber = new JSpinner();
        unitNumber.setValue(1);
        applyBtn = new JButton(" Apply ");
        cancelBtn = new JButton(" Cancel ");
        GridLayout gridLayout = new GridLayout(5, 2);
        gridLayout.setVgap(10);
        panel = new JPanel(gridLayout);
        panel.add(label);
        panel.add(professorNameCombo);
        panel.add(CourseNameLabel);
        panel.add(teacherCourseNameTxt);
        panel.add(unit);
        panel.add(unitNumber);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.add(new JLabel());
        panel.add(applyBtn);
        panel.add(new JLabel());
        panel.add(cancelBtn);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        applyBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("ADD COURSE");
        setSize(450, 200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String courseName = teacherCourseNameTxt.getText().trim();
        String professorName = (String) professorNameCombo.getSelectedItem();
        if (ae.getSource() == applyBtn) {
            if (courseName == null || professorName == null || courseName.length() <= 0 || professorName.length() <= 0) {
                JOptionPane.showMessageDialog(this, "Please fill input fields");
            } else {
                Course course = new Course(courseName, professorName);
                course.setUnit((int) unitNumber.getValue());
                courseService.addCourse(course);
                teacherCourseNameTxt.setText("");
                professorNameCombo.setSelectedIndex(0);
                courseService.printCourses();
                JOptionPane.showMessageDialog(this, "Course is successfully added");
            }
        } else if (ae.getSource() == cancelBtn) {
            dispose();
        }


    }

}
