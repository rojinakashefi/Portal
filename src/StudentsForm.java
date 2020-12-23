import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * gui for students form like username,password,...
 * @author kashefi
 *  @version 0.0
 */
public class StudentsForm extends JFrame implements ActionListener {
    private JPanel panel;
    private JTable studentsTable;
    private JButton cancelBtn;
    private IStudentService studentService;
    private DefaultTableModel table_model;

    StudentsForm() {
        studentService = new StudentService();
        GridLayout gridLayout = new GridLayout(1, 2);
        gridLayout.setVgap(10);
        studentsTable = new JTable();
        String column_names[] = {"Username", "First Name", "Last Name"};
        table_model = new DefaultTableModel(column_names, 0);
        studentsTable = new JTable(table_model);
        setListOfStudents();
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

    private void setListOfStudents() {
        List<Student> students = studentService.getStudents();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            table_model.addRow(new Object[]{student.getUserName(), student.getfName(), student.getlName()});
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cancelBtn) {
            dispose();
        }
    }

}
