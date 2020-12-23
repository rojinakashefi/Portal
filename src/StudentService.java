import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService {
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
