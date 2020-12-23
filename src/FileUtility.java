import java.io.File;

/**
 * handling file event(read & write)
 * @author kashefi
 * @version 0.0
 */
public class FileUtility {

    /**
     * get two name of files
     * check which of is newer
     * return new file
     * @param name1
     * @param name2
     * @return
     */
    public static String getReadableFileName(String name1, String name2) {
        File f1 = new File(name1);
        File f2 = new File(name2);
        if (f1.lastModified() > f2.lastModified()) {
            return name1;
        }
        return name2;
    }

    /**
     * check which one is newer
     * use getReadableFileName
     * @param name1
     * @param name2
     * @return
     */
    public static String getWritableFileName(String name1, String name2) {
        if (getReadableFileName(name1, name2).equalsIgnoreCase(name1)) {
            return name2;
        }
        return name1;
    }

}
