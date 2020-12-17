import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeeklyMealPlanFormForStudent extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel saturday, sunday,monday,tuesday,wednesday,thursday;
    private JTextField saturdayPrice, sundayPrice,mondayPrice,tuesdayPrice,wednesdayPrice,thursdayPrice;
    private JComboBox satCombo;
    private JComboBox sunCombo;
    private JComboBox monCombo;
    private JComboBox tuesCombo;
    private JComboBox wednesdayCombo;
    private JComboBox thursCombo;

    private JButton applyBtn, cancelBtn;
    private IMealService mealService;

    WeeklyMealPlanFormForStudent() {
        saturdayPrice = new JTextField();
        saturdayPrice.setEditable(false);
        sundayPrice = new JTextField();
        sundayPrice.setEditable(false);
        mondayPrice = new JTextField();
        mondayPrice.setEditable(false);
        tuesdayPrice = new JTextField();
        tuesdayPrice.setEditable(false);
        wednesdayPrice = new JTextField();
        wednesdayPrice.setEditable(false);
        thursdayPrice = new JTextField();
        thursdayPrice.setEditable(false);
        saturdayPrice.setHorizontalAlignment(SwingConstants.CENTER);
        sundayPrice.setHorizontalAlignment(SwingConstants.CENTER);
        mondayPrice.setHorizontalAlignment(SwingConstants.CENTER);
        tuesdayPrice.setHorizontalAlignment(SwingConstants.CENTER);
        wednesdayPrice.setHorizontalAlignment(SwingConstants.CENTER);
        thursdayPrice.setHorizontalAlignment(SwingConstants.CENTER);
        mealService = new MealService();
        saturday = new JLabel();
        saturday.setText(" Saturday ");
        satCombo = new JComboBox();
        satCombo.setEditable(false);
        sunday = new JLabel();
        sunday.setText(" Sunday ");
        sunCombo = new JComboBox();
        sunCombo.setEditable(false);
        monday = new JLabel();
        monday.setText(" Monday ");
        monCombo = new JComboBox();
        monCombo.setEditable(false);
        tuesday = new JLabel();
        tuesday.setText(" Tuesday ");
        tuesCombo = new JComboBox();
        tuesCombo.setEditable(false);
        wednesday = new JLabel();
        wednesday.setText(" Wednesday ");
        wednesdayCombo = new JComboBox();
        wednesdayCombo.setEditable(false);
        thursday = new JLabel();
        thursday.setText(" Thursday ");
        thursCombo = new JComboBox();
        thursCombo.setEditable(false);
        applyBtn = new JButton(" Apply ");
        cancelBtn = new JButton(" Cancel ");
        GridLayout gridLayout = new GridLayout(8, 3);
        gridLayout.setVgap(10);
        gridLayout.setHgap(10);
        panel = new JPanel(gridLayout);
        panel.add(saturday);
        panel.add(satCombo);
        panel.add(saturdayPrice);
        panel.add(sunday);
        panel.add(sunCombo);
        panel.add(sundayPrice);
        panel.add(monday);
        panel.add(monCombo);
        panel.add(mondayPrice);
        panel.add(tuesday);
        panel.add(tuesCombo);
        panel.add(tuesdayPrice);
        panel.add(wednesday);
        panel.add(wednesdayCombo);
        panel.add(wednesdayPrice);
        panel.add(thursday);
        panel.add(thursCombo);
        panel.add(thursdayPrice);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.add(new JLabel());
        panel.add(applyBtn);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(cancelBtn);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        applyBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("WEEKLY MEAL PLAN");
        setSize(450, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == applyBtn) {

        } else if (ae.getSource() == cancelBtn) {
            dispose();
        }
    }

}
