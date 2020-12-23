import java.io.Serializable;

/**
 * course class we should write in file
 * @author kashefi
 * @version 0.0
 */
public class Course implements Serializable {
    private String courseName;
    private String professorName;
    private int unit;
    private double grade;

    /**
     * getting unit
     * @return units
     */
    public int getUnit() {
        return unit;
    }

    /**
     * setting units
     * @param unit
     */
    public void setUnit(int unit) {
        this.unit = unit;
    }

    /**
     * getting double
     * @return
     */
    public double getGrade() {
        return grade;
    }

    /**
     * setting grade
     * @param grade
     */
    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Course(String courseName, String professorName) {
        this.courseName = courseName;
        this.professorName = professorName;
    }

    /**
     * get course name
     * @return
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * setting course name
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * getting professorname
     * @return
     */
    public String getProfessorName() {
        return professorName;
    }

    /**
     * setting professor name
     * @param professorName
     */
    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }
}
