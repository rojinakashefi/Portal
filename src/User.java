enum UserRole{
    Admin,
    Professor,
    Student
}
public class User {

    private long Id;
    private String username;
    private String password;
    private UserRole userRole;

    public User() {
    }

    public User(long id, String username, String password, UserRole userRole) {
        Id = id;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
