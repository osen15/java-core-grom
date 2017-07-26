package lesson19.HW;


public class File {
    private long id;
    private String name;
    private String format;
    private long size;

    public File(long id, String format, long size) {
        this.id = id;

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
}
