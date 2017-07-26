package lesson19.HW;


public class File {
    private long id;
    private String name;
    private String format;
    private long size;

   public File(long id, String name, String format, long size) {
        this.id = id;
        this.name = name;
        this.format = format;
        this.size = size;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public long getSize() {
        return size;
    }
    private boolean checkLenght(File file) throws Exception {  // метод перевірки допустимої довжини назви файла
       if (file.getName().length() > 10)
           throw new Exception(file.getName() + " >10");
       return true;


    }
}
