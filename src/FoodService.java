import java.io.*;
import java.util.List;

/**
 * handling food services like get foods, print foods
 * @author kashefi
 * @version 0.0
 */
public class FoodService implements IFoodService {

    /**
     * write meal to file
     * @param food
     */
    @Override
    public void addWeaklyMealPlan(Food food) {
        try {
            String fileName = FOOD_FILE_NAME_First;
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(food);
            out.close();
            fileOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * getting foods from file
     * @return
     */
    @Override
    public Food getFoods() {
        Food food = null;
        String fileName = FOOD_FILE_NAME_First;
        File f = new File(fileName);
        if (f.exists()) {
            ObjectInputStream ois = null;
            try {
                FileInputStream fis = new FileInputStream(fileName);
                ois = new ObjectInputStream(fis);
                food = (Food) ois.readObject();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                //end of file exception -> do nothing
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return food;
    }

    /**
     * print foods information
     */
    @Override
    public void prindFoods() {
        String fileName = FOOD_FILE_NAME_First;
        File f = new File(fileName);
        if (f.exists()) {
            ObjectInputStream ois = null;
            try {
                FileInputStream fis = new FileInputStream(fileName);
                ois = new ObjectInputStream(fis);
                while (true) {
                    Food food = (Food) ois.readObject();
                    System.out.println("saturday: " + food.getSaturdayday().getFood() + " , " + "price: " + food.getSaturdayday().getPrice());
                    System.out.println("sunday: " + food.getSunday().getFood() + " , " + "price: " + food.getSunday().getPrice());
                    System.out.println("monday: " + food.getMonday().getFood() + " , " + "price: " + food.getMonday().getPrice());
                    System.out.println("tuesday: " + food.getTuesday().getFood() + " , " + "price: " + food.getTuesday().getPrice());
                    System.out.println("wednesday: " + food.getWednesday().getFood() + " , " + "price: " + food.getWednesday().getPrice());
                    System.out.println("thirsday: " + food.getThursday().getFood() + " , " + "price: " + food.getThursday().getPrice());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                //end of file exception -> do nothing
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


}
