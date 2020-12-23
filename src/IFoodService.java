import java.util.List;

/**
 * we use this interface and implement their methods in their classes
 * @author kashefi
 * @version 0.0
 */
public interface IFoodService {
    final static String FOOD_FILE_NAME_First = "food.txt";

    void addWeaklyMealPlan(Food food);
    Food getFoods();
    void prindFoods();
}
