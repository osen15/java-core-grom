package lesson35.DAO;

import java.io.File;
import java.io.FileNotFoundException;

public class ValidateFileDb {
    public void validate(String fileFromPath) throws Exception { // валідація
        if (fileFromPath == null) {
            throw new Exception("Path can't be null");
        }
        File fileFrom = new File(fileFromPath);
        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFromPath + " doesn't exist");
        }
        if (!fileFrom.canRead()) {
            throw new Exception("File: " + fileFromPath + "doesn't have permissions to be read");
        }

    }


}
