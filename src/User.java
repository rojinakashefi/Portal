import java.io.Serializable;

/**
 * we have 3 users,pro,admin,std which we write them in file
 * @author kashefi
 *  @version 0.0
 */
public class User implements Serializable {

    private String username;
    private String password;
    private UserRole userRole;

    public User() {
    }

    /**
     * @param username as username
     * @param password as password
     * @param userRole as role of people
     */
    public User(String username, String password, UserRole userRole) {
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    /**
     * @param username as username
     * @param password as password
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * getting username
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * setting username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * getting password
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * setting password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * getting userrole
     * @return
     */
    public UserRole getUserRole() {
        return userRole;
    }

    /**
     * setting userrole
     * @param userRole
     */
    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
