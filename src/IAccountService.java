import java.util.List;

public interface IAccountService {
    final static String ACCOUNT_FILE_NAME_First = "accounts1.txt";
    final static String ACCOUNT_FILE_NAME_Second = "accounts2.txt";

    User getUser(String username, String password);
    User getUser(String username);

    boolean changeUsername(String oldUsername, String newPassword);
    boolean changePassword(String username, String password);

    boolean isValidPassword(String pass);

    boolean isDuplicateUsername(String username);

    void addUser(String username, String password, UserRole role);
    void printUsers();
}
