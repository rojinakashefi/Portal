import java.io.Serializable;

/**
 * professor class which we handles professor fields
 * we write it in files
 * @author kashefi
 * @version 0.0
 */
public class Professor implements Serializable {
    private String fName;
    private String lName;
    private String userName;

    public Professor(String userName) {
        this.userName = userName;
    }

    /**
     * getting name of professor
     * @return
     */
    public String getfName() {
        return fName;
    }

    /**
     * setting professor
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
     * @param lName
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

}
