import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ChangeUsernameForm extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel userLabel, PassLabel, message;
    private JTextField userNameText;
    private JTextField newUsernameText;
    private JButton applyBtn, cancelBtn;
    private String currentUsername;
    private IUserService userService;

    ChangeUsernameForm(String username) {
        userService = new UserService();
        userLabel = new JLabel();
        userLabel.setText(" Old Username ");
        userNameText = new JTextField(username);
        userNameText.setEditable(false);
        currentUsername = username;
        userNameText.setHorizontalAlignment(SwingConstants.CENTER);
        PassLabel = new JLabel();
        PassLabel.setText(" New Username ");
        newUsernameText = new JTextField();
        newUsernameText.setHorizontalAlignment(SwingConstants.CENTER);
        applyBtn = new JButton(" Apply ");
        cancelBtn = new JButton(" Cancel ");
        GridLayout gridLayout = new GridLayout(4, 2);
        gridLayout.setVgap(10);
        panel = new JPanel(gridLayout);
        panel.add(userLabel);
        panel.add(userNameText);
        panel.add(PassLabel);
        panel.add(newUsernameText);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.add(new JLabel());
        panel.add(applyBtn);
        panel.add(new JLabel());
        panel.add(cancelBtn);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        applyBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("CHANGE USERNAME");
        setSize(450, 200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == applyBtn){
            boolean isChanged = userService.changeUsername(currentUsername);
            if (isChanged){
                JOptionPane.showMessageDialog(this,"username is successfully changed");
            }else{
                JOptionPane.showMessageDialog(this,"username is not changed, please try again");
            }
        }else if (ae.getSource() == cancelBtn){
            dispose();
        }
    }

}