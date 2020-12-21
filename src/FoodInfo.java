import java.io.Serializable;

public class FoodInfo implements Serializable {
    private String food;
    private String price;

    public FoodInfo(String food, String price) {
        this.food = food;
        this.price = price;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

