import java.io.Serializable;

public class Student implements Serializable {
    private String fName;
    private String lName;
    private String userName;
    private int credit;

    public Student(String userName, int credit) {
        this.userName = userName;
        this.credit = credit;
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
}
