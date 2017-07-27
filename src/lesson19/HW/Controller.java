package lesson19.HW;


public class Controller {
    public File put(Storage storage, File file) throws Exception {
        int index = 0;
        if (storage == null)
            throw new Exception("storage is detected");
        if (file == null)
            throw  new Exception("file is null");
        if (checkId(storage, file.getId()))
            throw new Exception(file.getId() + " bad ID");
        if (!checkFormat(storage, file))
            throw new Exception(file.getFormat() + " bad format");
        if (freeSpace(storage) < file.getSize())
            throw new Exception(storage.getId() + " : no space");
        if (!checkZeroLenght(storage))
            throw new Exception(storage.getId() + "array: lenght is 0");
        if (checkIdenticalFile(storage, file))
            throw new Exception(file.getId() + " already exists");

        for (File fileInStorage : storage.getFiles()) {
            if (fileInStorage == null) {
                storage.getFiles()[index] = file;
                return  file;
            }

            index++;
        }
        throw new Exception(storage.getId() + " array is full");
    }

    public void delete(Storage storage, File file) throws Exception {
        int index = 0;
        if (storage == null)
            throw new Exception("storage is null");
        if (file == null)
            throw  new  Exception("file is null");
        if (!checkId(storage, file.getId()))
            throw new Exception( file.getId() + " is not found in " + storage.getId());
        for (File file1 : storage.getFiles()) {
            if (file1 != null && file1.getId() == file.getId()) {
                storage.getFiles()[index] = null;

            }
            index++;
        }

    }

    public File[] transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        if (storageFrom == null || storageTo == null)
            throw new Exception("null is detected");
        if (freeSpace(storageTo) < sumSizeFiles(storageFrom))
            throw new Exception(storageTo.getId() + " : no space");
       // if (!checkArraySize(storageFrom, storageTo))
        //    throw new Exception(storageTo.getId() + " Array is full");
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
            throw new Exception(storageFrom.getId() + " : file with " + id + " is not found");
        for (File fileFrom : storageFrom.getFiles()) {
            if (fileFrom.getId() == id) {

                put(storageTo, fileFrom);
                break;
            }
        }
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
        long freeSp;                      // обчислення вільного місця в стореджі
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

    private boolean checkArraySize(Storage storageFrom, Storage storageTo) {
        // метод який перевіряє чи є місце в
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

    private boolean checkZeroLenght(Storage storage) {  // метод який перевіряє чи є в масиві файлів доступне місце
        return storage.getFiles().length != 0;
    }
    private boolean checkIdenticalFile(Storage storage, File file){
        for (File file1 : storage.getFiles()){
            if (file1 != null && file1.getId() == file.getId() && file1.getName().equals(file.getName()))
                return  true;

        }
        return  false;
    }
}