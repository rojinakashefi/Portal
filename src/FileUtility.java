import java.io.File;

public class FileUtility {

    public static String getReadableFileName(String name1, String name2) {
        File f1 = new File(name1);
        File f2 = new File(name2);
        if (f1.lastModified() > f2.lastModified()) {
            return name1;
        }
        return name2;
    }

    public static String getWritableFileName(String name1, String name2) {
        if (getReadableFileName(name1, name2).equalsIgnoreCase(name1)) {
            return name2;
        }
        return name1;
    }

}
