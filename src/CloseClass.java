import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CloseClass extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel selectLabel;
    private JComboBox classNameCombo;
    private JButton applyBtn, cancelBtn;
    private IProfessorService professorService;
    private IStudentService studentService;
    private List<Class> classes;
    private Student student;

    CloseClass() {
        studentService = new StudentService();
        professorService = new ProfessorService();
        selectLabel = new JLabel();
        selectLabel.setText(" Select Class for Close");
        classNameCombo = new JComboBox();
        setClasses();
        applyBtn = new JButton(" Apply ");
        cancelBtn = new JButton(" Cancel ");
        GridLayout gridLayout = new GridLayout(3, 2);
        gridLayout.setVgap(10);
        panel = new JPanel(gridLayout);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.add(selectLabel);
        panel.add(classNameCombo);
        panel.add(new JLabel());
        panel.add(applyBtn);
        panel.add(new JLabel());
        panel.add(cancelBtn);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        applyBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("SELECT CLASS");
        setSize(450, 250);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == applyBtn) {
            Class selectedClass = classes.get(classNameCombo.getSelectedIndex());
            List<Student> students = studentService.getStudents();
            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                student.remove(selectedClass);
                studentService.updateStudent(student);
            }
            professorService.remove(selectedClass);
            JOptionPane.showMessageDialog(this, "Successfully Class is Closed by " + AccountService.CurrentUsername);
        } else if (ae.getSource() == cancelBtn) {
            dispose();
        }

    }


    private void setClasses() {
        classes = professorService.getClasses();
        for (int i = 0; i < classes.size(); i++) {
            classNameCombo.addItem(classes.get(i).getCourse().getCourseName() + "|" +
                    classes.get(i).getCourse().getProfessorName() + "|" +
                    classes.get(i).getDay() + "|" +
                    getRange(classes.get(i).getTimeRange()) + "|units: " +
                    classes.get(i).getCourse().getUnit());
        }
    }

    private String getRange(int timeRange) {
        switch (timeRange) {
            case 0:
                return "8-10";
            case 1:
                return "10-12";
            case 2:
                return "14-16";
        }
        return "";
    }
}