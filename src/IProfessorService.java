import java.util.List;

public interface IProfessorService {
    final static String CLASS_FILE_NAME_First = "class1.txt";
    final static String CLASS_FILE_NAME_Second = "class2.txt";

    List<Course> getCourses();
    List<Class> getClasses();

    boolean isConflict(Class cls);

    void addClass(Class cls);

    void printClasses();
}
