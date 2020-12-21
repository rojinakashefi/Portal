import java.io.Serializable;

public class Course implements Serializable {
    private String courseName;
    private String professorName;

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
