public class MockUserCreator {
    public static User AdminUserSample = new User(1, "admin", "admin", UserRole.Admin);
    public static User ProfessorUserSample = new User(2, "prof", "prof", UserRole.Professor);
    public static User StudentUserSample = new User(3, "std", "std", UserRole.Student);

    MockUserCreator() {
    }
    public static boolean isLogin(String username, String password) {
        if (username.equalsIgnoreCase(AdminUserSample.getUsername())) {
            return password.equals(AdminUserSample.getPassword());
        } else if (username.equalsIgnoreCase(StudentUserSample.getUsername())) {
            return password.equals(StudentUserSample.getPassword());
        } else if (username.equalsIgnoreCase(ProfessorUserSample.getUsername())) {
            return password.equals(ProfessorUserSample.getPassword());
        }
        return false;
    }
    public static User getUser(String username, String password) {
        if (username.equalsIgnoreCase(AdminUserSample.getUsername())) {
            return AdminUserSample;
        } else if (username.equalsIgnoreCase(StudentUserSample.getUsername())) {
            return StudentUserSample;
        } else if (username.equalsIgnoreCase(ProfessorUserSample.getUsername())) {
            return ProfessorUserSample;
        }
        return null;
    }

}