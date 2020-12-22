import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeeklyMealPlanFormForAdmin extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel saturday, sunday, monday, tuesday, wednesday, thursday;
    private JTextField saturdayPrice, sundayPrice, mondayPrice, tuesdayPrice, wednesdayPrice, thursdayPrice;
    private JComboBox satCombo;
    private JComboBox sunCombo;
    private JComboBox monCombo;
    private JComboBox tuesCombo;
    private JComboBox wednesdayCombo;
    private JComboBox thursCombo;

    private JButton applyBtn, cancelBtn;
    private IFoodService foodService;

    WeeklyMealPlanFormForAdmin() {
        saturdayPrice = new JTextField();
        sundayPrice = new JTextField();
        mondayPrice = new JTextField();
        tuesdayPrice = new JTextField();
        wednesdayPrice = new JTextField();
        thursdayPrice = new JTextField();
        saturdayPrice.setHorizontalAlignment(SwingConstants.CENTER);
        sundayPrice.setHorizontalAlignment(SwingConstants.CENTER);
        mondayPrice.setHorizontalAlignment(SwingConstants.CENTER);
        tuesdayPrice.setHorizontalAlignment(SwingConstants.CENTER);
        wednesdayPrice.setHorizontalAlignment(SwingConstants.CENTER);
        thursdayPrice.setHorizontalAlignment(SwingConstants.CENTER);
        foodService = new FoodService();
        saturday = new JLabel();
        saturday.setText(" Saturday ");
        satCombo = new JComboBox(getItems());
        satCombo.setEditable(false);
        satCombo.setSelectedIndex(0);
        sunday = new JLabel();
        sunday.setText(" Sunday ");
        sunCombo = new JComboBox(getItems());
        sunCombo.setSelectedIndex(1);
        sunCombo.setEditable(false);
        monday = new JLabel();
        monday.setText(" Monday ");
        monCombo = new JComboBox(getItems());
        monCombo.setSelectedIndex(2);
        monCombo.setEditable(false);
        tuesday = new JLabel();
        tuesday.setText(" Tuesday ");
        tuesCombo = new JComboBox(getItems());
        tuesCombo.setSelectedIndex(3);
        tuesCombo.setEditable(false);
        wednesday = new JLabel();
        wednesday.setText(" Wednesday ");
        wednesdayCombo = new JComboBox(getItems());
        wednesdayCombo.setSelectedIndex(4);
        wednesdayCombo.setEditable(false);
        thursday = new JLabel();
        thursday.setText(" Thursday ");
        thursCombo = new JComboBox(getItems());
        thursCombo.setSelectedIndex(5);
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
            if (sundayPrice.getText().trim() == null || mondayPrice.getText().trim() == null
                    || saturdayPrice.getText().trim() == null || tuesdayPrice.getText().trim() == null ||
                    thursdayPrice.getText().trim() == null || wednesdayPrice.getText().trim() == null) {
                JOptionPane.showMessageDialog(this, "Please fill all prices");
            } else if (!isDifferentCombos()) {
                JOptionPane.showMessageDialog(this, "don't select duplicate food");
            } else {
                Food foods = new Food();
                foods.setSaturdayday(new FoodInfo((String) satCombo.getSelectedItem(), saturdayPrice.getText().trim()));
                foods.setSunday(new FoodInfo((String) sunCombo.getSelectedItem(), sundayPrice.getText().trim()));
                foods.setMonday(new FoodInfo((String) monCombo.getSelectedItem(), mondayPrice.getText().trim()));
                foods.setThursday(new FoodInfo((String) thursCombo.getSelectedItem(), thursdayPrice.getText().trim()));
                foods.setWednesday(new FoodInfo((String) wednesdayCombo.getSelectedItem(), wednesdayPrice.getText().trim()));
                foods.setTuesday(new FoodInfo((String) tuesCombo.getSelectedItem(), tuesdayPrice.getText().trim()));
                foodService.addWeaklyMealPlan(foods);
                JOptionPane.showMessageDialog(this, "Weakly meal plan is successfully saved");
                foodService.printFoods();
            }
        } else if (ae.getSource() == cancelBtn) {
            dispose();
        }
    }

    private String[] getItems() {
        return new String[]{"Fries and Chicken", "Piza", "Pasta", "Hamburger", "Nuggets and Fries", "Tomato Soup"};
    }

    private boolean isDifferentCombos() {
        int satSelectedIndex = satCombo.getSelectedIndex();
        int sunSelectedIndex = sunCombo.getSelectedIndex();
        int monSelectedIndex = monCombo.getSelectedIndex();
        int tuesSelectedIndex = tuesCombo.getSelectedIndex();
        int wednesSelectedIndex = wednesdayCombo.getSelectedIndex();
        int thirsSelectedIndex = thursCombo.getSelectedIndex();
        if (satSelectedIndex != sunSelectedIndex && sunSelectedIndex != monSelectedIndex
                && monSelectedIndex != tuesSelectedIndex && tuesSelectedIndex != thirsSelectedIndex
                && thirsSelectedIndex != wednesSelectedIndex) {
            return true;
        }
        return false;
    }
}