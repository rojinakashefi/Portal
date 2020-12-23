import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * gui form for professor information form
 * @author kashefi
 * @version 0.0
 */
public class ProfessorInfoForm extends JFrame implements ActionListener {
    private JPanel panel, selectPanel;
    private JLabel label;
    private JComboBox selectProfNameCombo;
    private JTable professorInfoTable;
    private JButton cancelBtn;
    private IProfessorService professorService;
    private DefaultTableModel table_model;

    ProfessorInfoForm() {
        professorService = new ProfessorService();
        GridLayout gridLayout = new GridLayout(1, 2);
        gridLayout.setVgap(10);
        label = new JLabel();
        label.setText(" Select Professor ");
        selectProfNameCombo = new JComboBox();
        setProfessors();
        selectPanel = new JPanel(gridLayout);
        professorInfoTable = new JTable();
        String column_names[] = {"Course Name", "Day", "Time Range"};
        table_model = new DefaultTableModel(column_names, 0);
        setClassesInfo((String) selectProfNameCombo.getSelectedItem());
        professorInfoTable = new JTable(table_model);
        cancelBtn = new JButton(" Cancel ");
        panel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);
        selectPanel.add(label);
        selectPanel.add(selectProfNameCombo);
        selectProfNameCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setClassesInfo((String) selectProfNameCombo.getSelectedItem());
            }
        });
        panel.add(selectPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(new JScrollPane(professorInfoTable));
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(cancelBtn);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cancelBtn.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Class");
        setSize(450, 310);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setVisible(true);
    }

    private void setClassesInfo(String profName) {
        List<Class> classes = professorService.getClasses();
        int rowCount = table_model.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            table_model.removeRow(i);
        }
        for (int k = 0; k < classes.size(); k++) {
            Class cls = classes.get(k);
            if (cls.getCourse().getProfessorName().equalsIgnoreCase(profName)) {
                table_model.addRow(new Object[]{cls.getCourse().getCourseName(), cls.getDay(), getTimeRange(cls.getTimeRange())});
            }
        }
        table_model.fireTableDataChanged();
    }

    private String getTimeRange(int timeRange) {
        switch (timeRange) {
            case 0:
                return "8-10";
            case 1:
                return "10-12";
            case 2:
                return "14-16";
            default:
                break;
        }
        return null;
    }

    private void setProfessors() {
        List<Professor> professors = professorService.getProfessors();
        for (int i = 0; i < professors.size(); i++) {
            Professor professor = professors.get(i);
            selectProfNameCombo.addItem(professor.getUserName());
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cancelBtn) {
            dispose();
        }
    }

}
