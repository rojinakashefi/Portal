import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccountService implements IAccountService {

    private final static String ACCOUNT_FILE_NAME = "accounts.txt";

    private List<User> getAllUsers() {
        List<User> results = new ArrayList<User>();
        File f = new File(ACCOUNT_FILE_NAME);
        if (f.exists()) {
            ObjectInputStream ois = null;
            try {
                FileInputStream fis = new FileInputStream(ACCOUNT_FILE_NAME);
                ois = new ObjectInputStream(fis);
                while (true) {
                    results.add((User) ois.readObject());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                //end of file exception -> do nothing
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            createUsers();
        }
        return results;
    }

    private void createUsers() {
        try {
            FileOutputStream fileOut = new FileOutputStream(ACCOUNT_FILE_NAME);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(AdminUserSample);
            out.writeObject(ProfessorUserSample);
            out.writeObject(StudentUserSample);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/employee.ser");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public User getUser(String username, String password) {
        List<User> users = getAllUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equalsIgnoreCase(username) && users.get(i).getUsername().equalsIgnoreCase(password)) {
                return users.get(i);
            }
        }
        return null;
    }

    public boolean changeUsername(String oldUsername, String newUsername) {
        boolean isChanged = false;
        File f = new File(ACCOUNT_FILE_NAME);
        if (f.exists()) {
            ObjectInputStream ois = null;
            ObjectOutputStream oos = null;
            FileInputStream fis = null;
            FileOutputStream fos = null;
            try {
                fis = new FileInputStream(ACCOUNT_FILE_NAME);
                fos = new FileOutputStream("temp.txt");
                ois = new ObjectInputStream(fis);
                oos = new ObjectOutputStream(fos);
                while (true) {
                    User user = (User) ois.readObject();
                    if (user.getUsername().equalsIgnoreCase(oldUsername)) {
                        user.setUsername(newUsername);
                        isChanged = true;
                    }
                    oos.writeObject(user);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                //end of file exception -> remove main file and rename temp file
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    ois.close();
                    fis.close();
                    oos.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                File oldFile = new File("temp.txt");
                File newFile = new File(ACCOUNT_FILE_NAME);
                oldFile.renameTo(newFile);
                oldFile.delete();
            }
        }
        return isChanged;

    }

    private User getUser(String username) {
        List<User> users = getAllUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equalsIgnoreCase(username)) {
                return users.get(i);
            }
        }
        return null;
    }

    public User AdminUserSample = new User(1, "admin", "admin", UserRole.Admin);
    public User ProfessorUserSample = new User(2, "prof", "prof", UserRole.Professor);
    public User StudentUserSample = new User(3, "std", "std", UserRole.Student);

}
