import java.io.Serializable;

/**
 * creating class
 * writing class information in file
 * @author kashefi
 * @version 0.0
 */
public class Class implements Serializable {
    private Course course;
    private int capacity;
    private int timeRange;
    private String day;

    /***
     * getting day
     * @return day
     */
    public String getDay() {
        return day;
    }

    /**
     * setting day
     * @param
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * getting course
     * @return
     */
    public Course getCourse() {
        return course;
    }

    /**
     * setting course
     * @param course
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * getting class capacity
     * @return
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * setting class capacity
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * getting time range
     * @return
     */
    public int getTimeRange() {
        return timeRange;
    }

    /**
     * setting time range of class
     * @param timeRange
     */
    public void setTimeRange(int timeRange) {
        this.timeRange = timeRange;
    }
}
