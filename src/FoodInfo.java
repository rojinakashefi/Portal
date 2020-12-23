import java.io.Serializable;

/**
 * creating food objects
 * @author kashefi
 * @version 0.0
 */
public class FoodInfo implements Serializable {
    private String food;
    private int price;

    public FoodInfo(String food, int price) {
        this.food = food;
        this.price = price;
    }

    /**
     * getting food
     * @return
     */
    public String getFood() {
        return food;
    }

    /**
     * setting food
     * @param food
     */
    public void setFood(String food) {
        this.food = food;
    }

    /**
     * getting price
     * @return
     */
    public int getPrice() {
        return price;
    }

    /**
     * setting price
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }
}

