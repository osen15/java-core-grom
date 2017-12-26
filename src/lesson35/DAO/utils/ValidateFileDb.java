package lesson35.DAO.utils;

import java.io.File;
import java.io.FileNotFoundException;

public class ValidateFileDb {
    public static void validateFile(String FileName) throws Exception { // валідація
        if (FileName == null) {
            throw new Exception("Path can't be null");
        }
        File fileFrom = new File(FileName);
        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + FileName + " doesn't exist");
        }
        if (!fileFrom.canRead()) {
            throw new Exception("File: " + FileName + "doesn't have permissions to be read");
        }

    }


}
