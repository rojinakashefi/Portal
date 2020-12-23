import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * we write student information like name, ... if file
 *  @author kashefi
 *  @version 0.0
 */
public class Student implements Serializable {
    private String fName;
    private String lName;
    private String userName;
    private int credit;

    /**
     * getting classes
     * @return
     */
    public List<Class> getClasses() {
        return classes;
    }

    /**
     *setting class
     * @param classes
     */
    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }


    public List<Class> classes;

    public Student(String userName, int credit) {
        this.userName = userName;
        this.credit = credit;
        this.classes = new ArrayList<>();
    }

    /**
     * getting name
     * @return
     */
    public String getfName() {
        return fName;
    }

    /**
     * setting name
     * @param fName
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * getting name
     * @return
     */
    public String getlName() {
        return lName;
    }

    /**
     * setting name
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * getting username
     * @return
     */
    public String getUserName() {
        return userName;
    }

    /**
     * setting username
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * getting credit
     * @return
     */
    public int getCredit() {
        return credit;
    }

    /**
     * setting creidit
     * @param credit
     */
    public void setCredit(int credit) {
        this.credit = credit;
    }

    /**
     * getting avergae
     * @return
     */
    public double getAvergae() {
        double sum = 0;
        for (int i = 0; i < classes.size(); i++) {
            sum += classes.get(i).getCourse().getGrade();
        }
        return sum / getUnits();
    }

    /**
     * getting units
     * @return
     */
    public int getUnits() {
        int sumOfUnits = 0;
        for (int i = 0; i < classes.size(); i++) {
            sumOfUnits += classes.get(i).getCourse().getUnit();
        }
        return sumOfUnits;
    }

    /**
     * check if we can continue getting course or not
     * @param unit
     * @return
     */
    public boolean isRemainUnits(int unit) {
        double avg = getAvergae();
        int currentUnits = getUnits();
        if (avg >= 17) {
            return (unit + currentUnits) <= 24;
        } else {
            return (unit + currentUnits) <= 20;
        }
    }

    /**
     * checking repitition course
     */
    public boolean isSelectDuplicateCourse(String courseName) {
        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).getCourse().getCourseName().equalsIgnoreCase(courseName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * close class from student form
     * @param selectedClass
     */
    public void remove(Class selectedClass) {
        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).getCourse().getCourseName().equalsIgnoreCase(selectedClass.getCourse().getCourseName())
                    && classes.get(i).getCourse().getProfessorName().equalsIgnoreCase(selectedClass.getCourse().getProfessorName())
                    && classes.get(i).getDay().equalsIgnoreCase(selectedClass.getDay())
                    && classes.get(i).getTimeRange() == selectedClass.getTimeRange()) {
                classes.remove(i);
            }
        }
    }
    /**
     * getting class with name of professor
     */
    public Class getClassWithProfessor(String currentUsername) {
        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).getCourse().getProfessorName().equalsIgnoreCase(currentUsername)) {
                return classes.get(i);
            }
        }
        return null;
    }

    /**
     * getting selected class by course name
     * @param courseName
     * @return
     */
    public Class getSelectedClassByCourseName(String courseName) {
        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).getCourse().getCourseName().equalsIgnoreCase(courseName)) {
                return classes.get(i);
            }
        }
        return null;
    }

    /**
     * updating class
     * @param cls
     */
    public void update(Class cls) {
        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).getCourse().getCourseName().equalsIgnoreCase(cls.getCourse().getCourseName())) {
                classes.set(i, cls);
            }
        }
    }
}
