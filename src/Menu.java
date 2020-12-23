import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * creating parents class for menu which contains edit username, password and sign out
 * @author kashefi
 * @version 0.0
 */
public abstract class Menu extends JFrame implements ActionListener {
    protected JPanel panel;
    protected JButton changeUsernameBtn;
    protected JButton changePasswordBtn;
    protected JButton signOutBtn;
    protected String username;
    protected GridLayout gridLayout;

    Menu(String username, String title, int numberOfGridRows, int height) {
        this.username = username;
        changeUsernameBtn = new JButton(" Edit Username ");
        changePasswordBtn = new JButton(" Edit Password ");
        signOutBtn = new JButton(" Sign Out ");
        gridLayout = new GridLayout(numberOfGridRows,1);
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
        setSize(450, height);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setVisible(true);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
