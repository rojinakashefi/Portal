import java.util.List;

public interface IFoodService {
    final static String FOOD_FILE_NAME_First = "food.txt";

    void addWeaklyMealPlan(Food food);
    Food getFoods();
    void prindFoods();
}
