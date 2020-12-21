import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProfessorClassForm extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel label, PassLabel, message;
    private JTextField teacherNameTxt;
    private JTextField teacherCourseNameTxt;
    private JButton applyBtn, cancelBtn;
    private IProfessorService professorService;

    AddProfessorClassForm() {
        professorService = new ProfessorService();
        label = new JLabel();
        label.setText(" Teacher Name ");
        teacherNameTxt = new JTextField();
        teacherNameTxt.setHorizontalAlignment(SwingConstants.CENTER);
        PassLabel = new JLabel();
        PassLabel.setText(" Course Name ");
        teacherCourseNameTxt = new JTextField();
        teacherCourseNameTxt.setHorizontalAlignment(SwingConstants.CENTER);
        applyBtn = new JButton(" Apply ");
        cancelBtn = new JButton(" Cancel ");
        GridLayout gridLayout = new GridLayout(4, 2);
        gridLayout.setVgap(10);
        panel = new JPanel(gridLayout);
        panel.add(label);
        panel.add(teacherNameTxt);
        panel.add(PassLabel);
        panel.add(teacherCourseNameTxt);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.add(new JLabel());
        panel.add(applyBtn);
        panel.add(new JLabel());
        panel.add(cancelBtn);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        applyBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("ADD CLASS");
        setSize(450, 200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == applyBtn){
        }else if (ae.getSource() == cancelBtn){
            dispose();
        }
    }

}