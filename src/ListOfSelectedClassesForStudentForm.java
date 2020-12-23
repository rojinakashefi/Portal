import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListOfSelectedClassesForStudentForm extends JFrame implements ActionListener {
    private JPanel panel;
    private JTable studentsTable;
    private JButton cancelBtn;
    private IStudentService studentService;
    private DefaultTableModel table_model;

    ListOfSelectedClassesForStudentForm() {
        studentService = new StudentService();
        GridLayout gridLayout = new GridLayout(1, 2);
        gridLayout.setVgap(10);
        studentsTable = new JTable();
        String column_names[] = {"Course Name", "Professor", "Units", "Day", "Time Range", "Capcity"};
        table_model = new DefaultTableModel(column_names, 0);
        studentsTable = new JTable(table_model);
        setListOfSelectedClasses();
        cancelBtn = new JButton(" Cancel ");
        panel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(new JScrollPane(studentsTable));
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(cancelBtn);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cancelBtn.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("STUDENT LIST");
        setSize(450, 310);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setVisible(true);
    }

    private void setListOfSelectedClasses() {
        Student student = studentService.getStudent(AccountService.CurrentUsername);
        for (int i = 0; i < student.getClasses().size(); i++) {
            Class aClass = student.getClasses().get(i);
            table_model.addRow(new Object[]{aClass.getCourse().getCourseName()
                    , aClass.getCourse().getCourseName()
                    , aClass.getCourse().getProfessorName()
                    , aClass.getCourse().getUnit()
                    , aClass.getDay()
                    , getTimeRange(aClass.getTimeRange())});
        }
    }

    private String getTimeRange(int timeRange) {
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

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cancelBtn) {
            dispose();
        }
    }

}
