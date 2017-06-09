package lesson14.Library;


public class User  {
    private String name;
    private String lastName;
    private long id;
    private String password;

    public User(String name, String lastName, long id, String password) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                '}';
    }
}
