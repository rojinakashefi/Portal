import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClassTimeForm extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel classNameLabel,capacityLabel,timeLabel;
    private JTextField classNameText;
    private JTextField capacityText;
    private JComboBox timeRangeCombo;
    private JButton applyBtn, cancelBtn;
    private IProfessorService professorService;

    AddClassTimeForm() {
        professorService = new ProfessorService();
        classNameLabel = new JLabel();
        classNameLabel.setText(" Course Name ");
        classNameText = new JTextField();
        classNameText.setHorizontalAlignment(SwingConstants.CENTER);
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
        panel.add(classNameText);
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
        setTitle("ADD PROFESSOR");
        setSize(450, 250);
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