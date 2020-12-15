public class MockUserCreator {
    public static User AdminUserSample = new User(1, "admin", "admin", UserRole.Admin);
    public static User ProfessorUserSample = new User(2, "prof", "prof", UserRole.Professor);
    public static User StudentUserSample = new User(3, "std", "std", UserRole.Student);

    MockUserCreator() {
    }
}