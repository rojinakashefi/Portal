import java.util.List;

/**
 * we use this interface and implement their methods in their classes
 * @author kashefi
 * @version 0.0
 */
public interface IStudentService {
    final static String STUDENT_FILE_NAME_First = "student1.txt";
    final static String STUDENT_FILE_NAME_Second = "student2.txt";

    void addStudent(Student std);
    Student getStudent(String username);
    void printStudents();
    List<Student> getStudents();
    boolean updateStudent(Student student);
}
