package lesson19.HW;


public class File {
    private long id;
    private String name;
    private String format;
    private long size;

    public File(long id, String name, String format, long size) throws Exception  {
        checkLenght(name);
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
    private void checkLenght(String name) throws Exception {// метод перевірки допустимої довжини назви файла
        if (name.length() > 10)
            throw new Exception("long name");
    }

}
