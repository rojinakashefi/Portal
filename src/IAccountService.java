import java.util.List;

public interface IAccountService {
    User getUser(String username, String password);
    boolean changeUsername(String oldUsername, String newPassword);
}
