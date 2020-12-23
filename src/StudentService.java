import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * handeling students service like adding students
 * @author kashefi
 *  @version 0.0
 */
public class StudentService implements IStudentService {
    /**
     * adding students using file
     * @param std
     */
    @Override
    public void addStudent(Student std) {
        String readableFileName = FileUtility.getReadableFileName(STUDENT_FILE_NAME_First, STUDENT_FILE_NAME_Second);
        File f = new File(readableFileName);
        if (f.exists()) {
            ObjectInputStream ois = null;
            ObjectOutputStream oos = null;
            FileInputStream fis = null;
            FileOutputStream fos = null;
            try {
                fis = new FileInputStream(readableFileName);
                fos = new FileOutputStream(FileUtility.getWritableFileName(STUDENT_FILE_NAME_First, STUDENT_FILE_NAME_Second));
                ois = new ObjectInputStream(fis);
                oos = new ObjectOutputStream(fos);
                while (true) {
                    Student s = (Student) ois.readObject();
                    oos.writeObject(s);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                //end of file exception -> remove main file and rename temp file
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    oos.writeObject(std);
                    ois.close();
                    fis.close();
                    oos.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                String fileName = FileUtility.getWritableFileName(STUDENT_FILE_NAME_First, STUDENT_FILE_NAME_Second);
                FileOutputStream fileOut = new FileOutputStream(fileName);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(std);
                out.close();
                fileOut.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * getting students using their username
     * @param username
     * @return
     */
    @Override
    public Student getStudent(String username) {
        List<Student> students = getStudents();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getUserName().equalsIgnoreCase(username)) {
                return students.get(i);
            }
        }
        return null;
    }

    /**
     * printing students
     */
    @Override
    public void printStudents() {
        String fileName = FileUtility.getReadableFileName(STUDENT_FILE_NAME_First, STUDENT_FILE_NAME_Second);
        File f = new File(fileName);
        if (f.exists()) {
            ObjectInputStream ois = null;
            try {
                FileInputStream fis = new FileInputStream(fileName);
                ois = new ObjectInputStream(fis);
                while (true) {
                    Student std = (Student) ois.readObject();
                    System.out.println("Student: " + std.getUserName() + " , " + "Credit: " + std.getCredit());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                //end of file exception -> do nothing
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * getting list of students using reading from file
     * @return
     */
    @Override
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        String fileName = FileUtility.getReadableFileName(STUDENT_FILE_NAME_First, STUDENT_FILE_NAME_Second);
        File f = new File(fileName);
        if (f.exists()) {
            ObjectInputStream ois = null;
            try {
                FileInputStream fis = new FileInputStream(fileName);
                ois = new ObjectInputStream(fis);
                while (true) {
                    Student std = (Student) ois.readObject();
                    students.add(std);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                //end of file exception -> do nothing
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return students;
    }

    /**
     * updating students
     * @param student
     * @return
     */
    @Override
    public boolean updateStudent(Student student) {
        boolean isChanged = false;
        String readableFileName = FileUtility.getReadableFileName(STUDENT_FILE_NAME_First, STUDENT_FILE_NAME_Second);
        File f = new File(readableFileName);
        if (f.exists()) {
            ObjectInputStream ois = null;
            ObjectOutputStream oos = null;
            FileInputStream fis = null;
            FileOutputStream fos = null;
            try {
                fis = new FileInputStream(readableFileName);
                fos = new FileOutputStream(FileUtility.getWritableFileName(STUDENT_FILE_NAME_First, STUDENT_FILE_NAME_Second));
                ois = new ObjectInputStream(fis);
                oos = new ObjectOutputStream(fos);
                while (true) {
                    Student std = (Student) ois.readObject();
                    if (std.getUserName().equalsIgnoreCase(student.getUserName())) {
                        std.setfName(student.getfName());
                        std.setlName(student.getlName());
                        std.setCredit(student.getCredit());
                        std.setUserName(student.getUserName());
                        std.setClasses(student.getClasses());
                        isChanged = true;
                    }
                    oos.writeObject(std);
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
            }
        }
        return isChanged;
    }
}
