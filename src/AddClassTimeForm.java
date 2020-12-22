import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AddClassTimeForm extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel classNameLabel, capacityLabel, timeLabel;
    private JComboBox classNameCombo;
    private JTextField capacityText;
    private JComboBox timeRangeCombo;
    private JButton applyBtn, cancelBtn;
    private IProfessorService professorService;
    private List<Course> courses;


    AddClassTimeForm() {
        professorService = new ProfessorService();
        classNameLabel = new JLabel();
        classNameLabel.setText(" Course Name ");
        classNameCombo = new JComboBox();
        setClassNames();
        capacityLabel = new JLabel();
        capacityLabel.setText(" Capacity ");
        capacityText = new JTextField();
        capacityText.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel = new JLabel();
        timeLabel.setText(" Time Range ");
        timeRangeCombo = new JComboBox();
        timeRangeCombo.addItem("8-10");
        timeRangeCombo.addItem("10-12");
        timeRangeCombo.addItem("14-16");
        capacityText.setHorizontalAlignment(SwingConstants.CENTER);
        applyBtn = new JButton(" Apply ");
        cancelBtn = new JButton(" Cancel ");
        GridLayout gridLayout = new GridLayout(5, 2);
        gridLayout.setVgap(10);
        panel = new JPanel(gridLayout);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.add(classNameLabel);
        panel.add(classNameCombo);
        panel.add(capacityLabel);
        panel.add(capacityText);
        panel.add(timeLabel);
        panel.add(timeRangeCombo);
        panel.add(new JLabel());
        panel.add(applyBtn);
        panel.add(new JLabel());
        panel.add(cancelBtn);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        applyBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("ADD CLASS");
        setSize(450, 250);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setVisible(true);
    }

    private void setClassNames() {
        courses = professorService.getCourses();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getProfessorName().equalsIgnoreCase(AccountService.CurrentUsername)) {
                classNameCombo.addItem(courses.get(i).getCourseName());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == applyBtn) {
            String capacity = capacityText.getText().trim();
            if (capacity == null) {
                JOptionPane.showMessageDialog(this, "Please fill all input fields");
            } else {
                Class cls = new Class();
                Course crs = getCourse((String) classNameCombo.getSelectedItem());
                if (crs == null)
                {
                    JOptionPane.showMessageDialog(this, "Course is not exit");
                    return;
                }
                cls.setCourse(crs);
                cls.setTimeRange(timeRangeCombo.getSelectedIndex());
                if (professorService.isConflict(cls)){
                    JOptionPane.showMessageDialog(this, "duplicate class");
                    return;
                }
                cls.setCapacity(Integer.parseInt(capacityText.getText().trim()));
                professorService.addClass(cls);
                professorService.printClasses();
                JOptionPane.showMessageDialog(this, "Class is successfully added");
            }
        } else if (ae.getSource() == cancelBtn) {
            dispose();
        }

    }


    private Course getCourse(String name) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseName().equalsIgnoreCase(name)) {
                return courses.get(i);
            }
        }
        return null;
    }
}