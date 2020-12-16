import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Menu extends JFrame implements ActionListener{
    JPanel panel;
    JButton changeUsernameBtn;
    JButton changePasswordBtn;
    JButton signOutBtn;

    Menu(String Username,String title){
        changeUsernameBtn = new JButton(" Edit Username ");
        changePasswordBtn = new JButton(" Edit Password ");
        signOutBtn = new JButton(" Sign Out ");
        GridLayout gridLayout = new GridLayout(3, 2);
        gridLayout.setVgap(10);
        panel = new JPanel(gridLayout);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.add(changeUsernameBtn);
        panel.add(changePasswordBtn);
        panel.add(signOutBtn);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        changeUsernameBtn.addActionListener(this);
        changePasswordBtn.addActionListener(this);
        signOutBtn.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle(title);
        setSize(450, 200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setVisible(true);
    }

}
