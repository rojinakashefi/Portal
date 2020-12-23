import java.io.Serializable;

/**
 * handling food schedule
 * @author kashefi
 * @version 0.0
 */
public class Food implements Serializable {
    private FoodInfo saturday;
    private FoodInfo sunday;
    private FoodInfo monday;
    private FoodInfo tuesday;
    private FoodInfo wednesday;
    private FoodInfo thursday;

    /**
     * getting saturday day
     * @return
     */
    public FoodInfo getSaturdayday() {
        return saturday;
    }

    /**
     * setting saturday day
     * @param saturday
     */
    public void setSaturdayday(FoodInfo saturday) {
        this.saturday = saturday;
    }

    /**
     * getting sunday
     * @return
     */
    public FoodInfo getSunday() {
        return sunday;
    }

    /**
     * setting sunday
     * @param sunday
     */
    public void setSunday(FoodInfo sunday) {
        this.sunday = sunday;
    }

    /**
     * getting monday
     * @return
     */
    public FoodInfo getMonday() {
        return monday;
    }

    /**
     * setting monday
     * @param monday
     */
    public void setMonday(FoodInfo monday) {
        this.monday = monday;
    }

    /**
     * getting tuesday
     * @return
     */
    public FoodInfo getTuesday() {
        return tuesday;
    }

    /**
     * setting tuesday
     * @param tuesday
     */
    public void setTuesday(FoodInfo tuesday) {
        this.tuesday = tuesday;
    }

    /**
     * getting wednesday
     * @return
     */
    public FoodInfo getWednesday() {
        return wednesday;
    }

    /**
     * setting wednesday
     * @param wednesday
     */
    public void setWednesday(FoodInfo wednesday) {
        this.wednesday = wednesday;
    }

    /**
     * getting thursday
     * @return
     */
    public FoodInfo getThursday() {
        return thursday;
    }

    /**
     * setting thursday
     * @param thursday
     */
    public void setThursday(FoodInfo thursday) {
        this.thursday = thursday;
    }

    /**
     * getting day prices
     * @return
     */
    public int getPrice() {
        return getSaturdayday().getPrice() + getSunday().getPrice() + getMonday().getPrice()
                + getThursday().getPrice() + getTuesday().getPrice() + getWednesday().getPrice();
    }
}

