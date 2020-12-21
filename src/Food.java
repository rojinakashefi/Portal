import java.io.Serializable;

public class Food implements Serializable {
    private FoodInfo saturday;
    private FoodInfo sunday;
    private FoodInfo monday;
    private FoodInfo tuesday;
    private FoodInfo wednesday;
    private FoodInfo thursday;

    public FoodInfo getSaturdayday() {
        return saturday;
    }

    public void setSaturdayday(FoodInfo saturday) {
        this.saturday = saturday;
    }

    public FoodInfo getSunday() {
        return sunday;
    }

    public void setSunday(FoodInfo sunday) {
        this.sunday = sunday;
    }

    public FoodInfo getMonday() {
        return monday;
    }

    public void setMonday(FoodInfo monday) {
        this.monday = monday;
    }

    public FoodInfo getTuesday() {
        return tuesday;
    }

    public void setTuesday(FoodInfo tuesday) {
        this.tuesday = tuesday;
    }

    public FoodInfo getWednesday() {
        return wednesday;
    }

    public void setWednesday(FoodInfo wednesday) {
        this.wednesday = wednesday;
    }

    public FoodInfo getThursday() {
        return thursday;
    }

    public void setThursday(FoodInfo thursday) {
        this.thursday = thursday;
    }
}

