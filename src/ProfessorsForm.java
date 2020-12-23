import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * gui form for professor form like username,first password,lastname,...
 *  @author kashefi
 *  @version 0.0
 */
public class ProfessorsForm extends JFrame implements ActionListener {
    private JPanel panel;
    private JTable studentsTable;
    private JButton cancelBtn;
    private IProfessorService professorService;
    private DefaultTableModel table_model;

    ProfessorsForm() {
        professorService = new ProfessorService();
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
        setTitle("PROFESSOR LIST");
        setSize(450, 310);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setVisible(true);
    }

    /**
     * setting list of students of professor
     */
    private void setListOfStudents() {
        List<Professor> professors = professorService.getProfessors();
        for (int i = 0; i < professors.size(); i++) {
            Professor professor = professors.get(i);
            table_model.addRow(new Object[]{professor.getUserName(), professor.getfName(), professor.getlName()});
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cancelBtn) {
            dispose();
        }
    }

}
