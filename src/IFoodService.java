public interface IFoodService {
    final static String FOOD_FILE_NAME_First = "food.txt";

    void addWeaklyMealPlan(Food food);
    void printFoods();
}
