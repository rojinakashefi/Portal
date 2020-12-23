import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
    private String fName;
    private String lName;
    private String userName;
    private int credit;

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public List<Class> classes;

    public Student(String userName, int credit) {
        this.userName = userName;
        this.credit = credit;
        this.classes = new ArrayList<>();
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }


    public double getAvergae() {
        double sum = 0;
        for (int i = 0; i < classes.size(); i++) {
            sum += classes.get(i).getCourse().getGrade();
        }
        return sum / getUnits();
    }

    public int getUnits() {
        int sumOfUnits = 0;
        for (int i = 0; i < classes.size(); i++) {
            sumOfUnits += classes.get(i).getCourse().getUnit();
        }
        return sumOfUnits;
    }

    public boolean isRemainUnits(int unit) {

        double avg = getAvergae();
        int currentUnits = getUnits();
        if (avg >= 17) {
            return (unit + currentUnits) <= 24;
        } else {
            return (unit + currentUnits) <= 20;
        }
    }

    public boolean isSelectDuplicateCourse(String courseName) {
        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).getCourse().getCourseName().equalsIgnoreCase(courseName)) {
                return true;
            }
        }
        return false;
    }

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

    public Class getClassWithProfessor(String currentUsername) {
        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).getCourse().getProfessorName().equalsIgnoreCase(currentUsername)) {
                return classes.get(i);
            }
        }
        return null;
    }

    public Class getSelectedClassByCourseName(String courseName) {
        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).getCourse().getCourseName().equalsIgnoreCase(courseName)) {
                return classes.get(i);
            }
        }
        return null;
    }

    public void update(Class cls) {
        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).getCourse().getCourseName().equalsIgnoreCase(cls.getCourse().getCourseName())) {
                classes.set(i, cls);
            }
        }
    }
}
