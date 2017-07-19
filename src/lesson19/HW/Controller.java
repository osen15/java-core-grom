package lesson19.HW;


import java.util.Arrays;

public class Controller {
    public File put(Storage storage, File file) throws Exception {
        int index = 0;
        if (storage == null || file == null)
            throw new Exception("null is detected");
        try {
            if (checkId(storage, file.getId()) && checkLenght(file) && checkFormat(storage, file)) {
                for (File fileInStorage : storage.getFiles()) {
                    if (freeSpace(storage) > file.getSize() && fileInStorage == null) {
                        storage.getFiles()[index] = file;
                        System.out.println(storage.getFiles()[index]);
                    }

                    index++;
                }
            }

        } catch (Exception e) {
            System.err.println("Error");
        }
        return null;
    }

    public File delete(Storage storage, File file) throws Exception {

        int index = 0;

        if (storage == null || file == null)
            throw new Exception("null is detected");

        for (File file1 : storage.getFiles()) {
            try {
                if (file1.getId() == file.getId()) {

                    storage.getFiles()[index] = null;
                    return storage.getFiles()[index];
                }
                index++;
            } catch (Exception e) {
                System.err.println("Error");
            }
        }
        return null;
    }

    public File[] transferAll(Storage storageFrom, Storage storageTo) throws Exception {

        if (storageFrom == null || storageTo == null)
            throw new Exception("null is detected");


        if (checkArraySize(storageFrom, storageTo) && freeSpace(storageTo) > sumSizeFiles(storageFrom)){
            for (int i = 0; i < storageFrom.getFiles().length; i++) {
                for (int j = 0; j < storageTo.getFiles().length; j++) {
                    if (!checkFormat(storageTo, storageFrom.getFiles()[i])) {
                        return null;

                    }else if (storageFrom.getFiles()[i] != null  && storageTo.getFiles()[j] == null &&
                            checkFormat(storageTo, storageFrom.getFiles()[i]))
                        storageTo.getFiles()[j] = storageFrom.getFiles()[i++];

                }
            }
            return storageTo.getFiles();
        }
        return null;
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
        if (storageFrom == null || storageTo == null)
            throw new Exception("null is detected");

        for (File filesFrom : storageFrom.getFiles()) {

            if (filesFrom != null && filesFrom.getId() == id) {

                put(storageTo, filesFrom);

                System.out.println(Arrays.toString(storageTo.getFiles()));
            }

        }
    }

    private boolean checkLenght(File file) {  // метод чи пыдходить формат
        return file.getName().length() <= 10;


    }

    private  boolean checkFormat(Storage storage, File file){
        for (String format : storage.getFormatsSupported()){
            if (file != null && file.getFormat().equals(format))
               return true;
        }
        return false;
    }

    private boolean checkId(Storage storage, long id) {  // метод перевірки файла по його айді та імені
        for (File file1 : storage.getFiles()) {
            if (file1.getId() != id)
                return true;
            else return false;

        }
        return false;

    }

    private long freeSpace(Storage storage) {
        long freeSp = 0;                      // обчислення вільного місця в стореджі
        freeSp = storage.getStorageSize() - sumSizeFiles(storage);
        return freeSp;
    }

    private long sumSizeFiles(Storage storage) {   // метод який рахує суму розмірів всіх непорожніх файлів в стореджі
        long sum = 0;
        for (File file : storage.getFiles()) {
            if (file != null)
                sum += file.getSize();
        }

        return sum;
    }

    private boolean checkArraySize(Storage storageFrom, Storage storageTo) { // метод який перевіряє чи є місце в  масиві стореджа до якого будуть здійснювати трансфер
        int countFrom = 0;
        int countTo = 0;

        for (File fileFrom : storageFrom.getFiles()) {
            if (fileFrom != null)
                countFrom++;
        }
        for (File fileTo : storageTo.getFiles()) {
            if (fileTo == null)
                countTo++;
        }
        return countFrom <= countTo;
    }
}
