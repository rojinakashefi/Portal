import java.io.*;

public class FoodService implements IFoodService {

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

    @Override
    public void printFoods() {
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
