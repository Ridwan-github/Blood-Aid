package external_Functions;

import java.io.File;

public class MyFileOperations {
    public static boolean exists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    public static boolean createNewFile(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return file.createNewFile();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean delete(String filePath) {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                return file.delete();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}