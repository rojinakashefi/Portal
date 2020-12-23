import java.io.Serializable;

public class Course implements Serializable {
    private String courseName;
    private String professorName;
    private int unit;

    private double grade;

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Course(String courseName, String professorName) {
        this.courseName = courseName;
        this.professorName = professorName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }
}
