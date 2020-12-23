import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * gui form for payment form
 * @author kashefi
 * @version 0.0
 */
public class PaymentForm extends JFrame implements ActionListener {
    JPanel panel;
    JLabel cardLabel, pinLabel, message;
    JTextField cardTxt;
    JPasswordField pinText;
    JButton apply;
    int amount;
    IStudentService studentService;

    PaymentForm(int amount) {
        studentService = new StudentService();
        this.amount = amount;
        cardLabel = new JLabel();
        cardLabel.setText(" Card Label ");
        cardTxt = new JTextField();
        cardTxt.setHorizontalAlignment(SwingConstants.CENTER);
        pinLabel = new JLabel();
        pinLabel.setText(" PIN ");
        pinText = new JPasswordField();
        pinText.setHorizontalAlignment(SwingConstants.CENTER);
        apply = new JButton(" Apply ");
        GridLayout gridLayout = new GridLayout(3, 2);
        gridLayout.setVgap(10);
        panel = new JPanel(gridLayout);
        panel.add(cardLabel);
        panel.add(cardTxt);
        panel.add(pinLabel);
        panel.add(pinText);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        message = new JLabel();
        panel.add(message);
        panel.add(apply);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        apply.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Payment");
        setSize(450, 200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String card = cardTxt.getText().trim();
        String pin = pinText.getText().trim();
        if (card == null || card.length() == 0 || pin == null || pin.length() == 0) {
            JOptionPane.showMessageDialog(this, "please fill input fields");
            return;
        } else {
            Student s = studentService.getStudent(AccountService.CurrentUsername);
            s.setCredit(s.getCredit() + amount);
            studentService.updateStudent(s);
            JOptionPane.showMessageDialog(this, "payment is done successfully");
            dispose();
        }
    }

}
