import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradingForm extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel label, courseLabel, gradeLabel;
    private JTextField studentIdText,courseNameText,GradeText;
    private JButton applyBtn, cancelBtn;
    private IProfessorService professorService;

    GradingForm() {
        professorService = new ProfessorService();
        label = new JLabel();
        label.setText(" Student Id ");
        studentIdText = new JTextField();
        studentIdText.setHorizontalAlignment(SwingConstants.CENTER);
        courseNameText = new JTextField();
        courseNameText.setHorizontalAlignment(SwingConstants.CENTER);
        GradeText = new JTextField();
        GradeText.setHorizontalAlignment(SwingConstants.CENTER);
        courseLabel = new JLabel();
        courseLabel.setText(" Course Name ");
        gradeLabel = new JLabel();
        gradeLabel.setText(" Grade ");
        applyBtn = new JButton(" Apply ");
        cancelBtn = new JButton(" Cancel ");
        GridLayout gridLayout = new GridLayout(5, 2);
        gridLayout.setVgap(10);
        panel = new JPanel(gridLayout);
        panel.add(label);
        panel.add(studentIdText);
        panel.add(courseLabel);
        panel.add(courseNameText);
        panel.add(gradeLabel);
        panel.add(GradeText);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.add(new JLabel());
        panel.add(applyBtn);
        panel.add(new JLabel());
        panel.add(cancelBtn);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        applyBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("GRADING TO STUDENT");
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