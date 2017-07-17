package lesson19.HW;

public class Storage {
   private long id;
   private File[] files;
   private String[] formatsSupported;
   private String storageCoutry;
   private long storageSize;

    public Storage(long id, File[] files, String[] formatsSupported, String storageCoutry, long storageSize) {
        this.id = id;
        this.files = files;
        this.formatsSupported = formatsSupported;
        this.storageCoutry = storageCoutry;
        this.storageSize = storageSize;
    }

    public long getId() {
        return id;
    }

    public File[] getFiles() {
        return files;
    }

    public String[] getFormatsSupported() {
        return formatsSupported;
    }

    public String getStorageCoutry() {
        return storageCoutry;
    }

    public long getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(long storageSize) {
        this.storageSize = storageSize;
    }
}
