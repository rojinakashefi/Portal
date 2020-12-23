import java.util.List;

/**
 * we use this interface and implement their methods in their classes
 * @author kashefi
 * @version 0.0
 */
public interface IProfessorService {
    final static String CLASS_FILE_NAME_First = "class1.txt";
    final static String CLASS_FILE_NAME_Second = "class2.txt";
    final static String PROF_FILE_NAME_First = "professor1.txt";
    final static String PROF_FILE_NAME_Second = "professor2.txt";

    List<Course> getCourses();
    List<Class> getClasses();

    boolean isConflict(Class cls);

    void addProfessor(Professor professor);
    void addClass(Class cls);

    void printClasses();

    List<Professor> getProfessors();

    void updateClass(Class selectedClass);

    void remove(Class selectedClass);
}
