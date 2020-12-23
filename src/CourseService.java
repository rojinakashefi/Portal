import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * handling course services like add course, get course, ...
 * @author kashefi
 * @version 0.0
 */
public class CourseService implements ICourseService {
    /**
     * check if file exists or not, is exists write in file
     * add new course to file
     * @param course
     */
    @Override
    public void addCourse(Course course) {
        String readableFileName = FileUtility.getReadableFileName(COURSE_FILE_NAME_First, COURSE_FILE_NAME_Second);
        File f = new File(readableFileName);
        if (f.exists()) {
            ObjectInputStream ois = null;
            ObjectOutputStream oos = null;
            FileInputStream fis = null;
            FileOutputStream fos = null;
            try {
                fis = new FileInputStream(readableFileName);
                fos = new FileOutputStream(FileUtility.getWritableFileName(COURSE_FILE_NAME_First, COURSE_FILE_NAME_Second));
                ois = new ObjectInputStream(fis);
                oos = new ObjectOutputStream(fos);
                while (true) {
                    Course c = (Course) ois.readObject();
                    oos.writeObject(c);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                //end of file exception -> remove main file and rename temp file
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    oos.writeObject(course);
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
                String fileName = FileUtility.getWritableFileName(COURSE_FILE_NAME_First, COURSE_FILE_NAME_Second);
                FileOutputStream fileOut = new FileOutputStream(fileName);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(course);
                out.close();
                fileOut.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * there is two files which stores information, in file utility we check which one is newer then
     * we start reading from new file and get courses
     * @return list of courses
     */
    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String fileName = FileUtility.getReadableFileName(COURSE_FILE_NAME_First, COURSE_FILE_NAME_Second);
        File f = new File(fileName);
        if (f.exists()) {
            ObjectInputStream ois = null;
            try {
                FileInputStream fis = new FileInputStream(fileName);
                ois = new ObjectInputStream(fis);
                while (true) {
                    Course course = (Course) ois.readObject();
                    courses.add(course);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                //end of file exception -> do nothing
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return courses;
    }

    /**
     * print all courses
     */
    @Override
    public void printCourses() {
        String fileName = FileUtility.getReadableFileName(COURSE_FILE_NAME_First, COURSE_FILE_NAME_Second);
        File f = new File(fileName);
        if (f.exists()) {
            ObjectInputStream ois = null;
            try {
                FileInputStream fis = new FileInputStream(fileName);
                ois = new ObjectInputStream(fis);
                while (true) {
                    Course course = (Course) ois.readObject();
                    System.out.println("Course: " + course.getCourseName() + " , " + "Professor: " + course.getProfessorName());
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
}
