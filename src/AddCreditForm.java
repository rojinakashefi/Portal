import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * gui form for add credit form
 * @author kashefi
 * @version 0.
 */
public class AddCreditForm extends JFrame implements ActionListener {
    JPanel panel;
    JLabel currentCreditLabel, amountOfIncrementLabel, message;
    JTextField curtxt;
    JTextField amounttxt;
    JButton apply;
    IStudentService studentService;

    AddCreditForm() {
        studentService = new StudentService();
        currentCreditLabel = new JLabel();
        currentCreditLabel.setText(" Current Credit ");
        curtxt = new JTextField();
        int credit = studentService.getStudent(AccountService.CurrentUsername).getCredit();
        curtxt.setText(String.valueOf(credit));
        curtxt.setEditable(false);
        curtxt.setHorizontalAlignment(SwingConstants.CENTER);
        amountOfIncrementLabel = new JLabel();
        amountOfIncrementLabel.setText(" Amount ");
        amounttxt = new JTextField();
        amounttxt.setHorizontalAlignment(SwingConstants.CENTER);
        apply = new JButton(" Apply ");
        GridLayout gridLayout = new GridLayout(3, 2);
        gridLayout.setVgap(10);
        panel = new JPanel(gridLayout);
        panel.add(currentCreditLabel);
        panel.add(curtxt);
        panel.add(amountOfIncrementLabel);
        panel.add(amounttxt);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        message = new JLabel();
        panel.add(message);
        panel.add(apply);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        apply.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("ADD CREDIT");
        setSize(450, 200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String amount = amounttxt.getText().trim();
        if (amount == null) {
            JOptionPane.showMessageDialog(this, "please specify amount of increase");
            return;
        }

        new PaymentForm(Integer.parseInt(amount));
        dispose();
    }

}
