package lesson19.HW;


import java.util.Arrays;

public class Controller {
    public void put(Storage storage, File file) throws Exception {
        int index = 0;
        if (storage == null || file == null)
            throw new Exception("null is detected");
        if (checkId(storage, file.getId()))
            throw new Exception("bad ID");
        if (!checkLenght(file))
            throw new Exception("wrong lenght");
        if (!checkFormat(storage, file))
            throw new Exception("bad format");
        if (freeSpace(storage) < file.getSize())
            throw new Exception("no space");
        if (!checkArraySize(storage))
            throw new Exception("array is full");

        for (File fileInStorage : storage.getFiles()) {
            if (fileInStorage == null) {
                storage.getFiles()[index] = file;
                System.out.println(file);
                break;
            }

            index++;
        }

    }

    public File delete(Storage storage, File file) throws Exception {
        int index = 0;
        if (storage == null || file == null)
            throw new Exception("null is detected");
        for (File file1 : storage.getFiles()) {
            if (file1 != null && file1.getId() == file.getId()) {
                storage.getFiles()[index] = null;
                return storage.getFiles()[index];
            } else if ((index + 1) == storage.getFiles().length)
                throw new Exception("file is not found");
            index++;
        }
        return storage.getFiles()[index];
    }

    public File[] transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        if (storageFrom == null || storageTo == null)
            throw new Exception("null is detected");
        if (freeSpace(storageTo) < sumSizeFiles(storageFrom))
            throw new Exception("no space");
        if (!checkArraySize(storageFrom, storageTo))
            throw new Exception("Array is full");
        for (int i = 0; i < storageFrom.getFiles().length; i++) {
            if ((storageFrom.getFiles()[i] != null))
               put(storageTo, storageFrom.getFiles()[i]);
        }

        return storageTo.getFiles();
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {

        if (storageFrom == null || storageTo == null)
            throw new Exception("null is detected");
        if (!checkId(storageFrom, id))
            throw new Exception("StorareFrom: file is not found");
        for (File fileFrom : storageFrom.getFiles()) {
            if (fileFrom.getId() == id) {

                put(storageTo, fileFrom);
                break;

            }

        }


    }

    private boolean checkLenght(File file) {  // метод чи пыдходить формат
        return file.getName().length() <= 10;


    }

    private boolean checkFormat(Storage storage, File file) {
        for (String format : storage.getFormatsSupported()) {
            if (file != null && file.getFormat().equals(format))
                return true;
        }
        return false;
    }

    private boolean checkId(Storage storage, long id) {  // метод перевірки файла по його айді та імені

        for (File file : storage.getFiles()) {
            if (file != null && file.getId() == id)
                return true;

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

    private boolean checkArraySize(Storage storageFrom, Storage storageTo) { // метод який перевіряє чи є місце в
        // масиві стореджа до якого
        //буде здійснюватися трансфер
        //всіх файлів з іншоло стореджа
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

    private boolean checkArraySize(Storage storage) {  // метод який перевіряє чи є в масиві файлів доступне місце
        for (File file : storage.getFiles()) {
            if (file == null)
                return true;
        }
        return false;
    }
}