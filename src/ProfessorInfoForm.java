import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfessorInfoForm extends JFrame implements ActionListener {
    private JPanel panel,selectPanel;
    private JLabel label;
    private JComboBox selectProfNameCombo;
    private JTable professorInfoTable;
    private JButton cancelBtn;

    ProfessorInfoForm() {
        GridLayout gridLayout = new GridLayout(1,2);
        gridLayout.setVgap(10);
        label = new JLabel();
        label.setText(" Select Professor ");
        selectProfNameCombo = new JComboBox();
        selectPanel = new JPanel(gridLayout);
        professorInfoTable = new JTable();
        String column_names[]= {"Course Name","Time Range"};
        DefaultTableModel table_model = new DefaultTableModel(column_names,8);
        professorInfoTable =new JTable(table_model);
        cancelBtn = new JButton(" Cancel ");
        panel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);
        selectPanel.add(label);
        selectPanel.add(selectProfNameCombo);
        panel.add(selectPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(new JScrollPane(professorInfoTable));
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(cancelBtn);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cancelBtn.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("ADD PROFESSOR");
        setSize(450, 310);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cancelBtn) {
            dispose();
        }
    }

}
