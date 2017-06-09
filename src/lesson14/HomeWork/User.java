package lesson14.HomeWork;


import java.util.Date;

public class User {
    String name;
    String lastName;
    long id;
    String password;
    Date date;

    public User(String name, String lastName, long id, String password, Date date) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        this.password = password;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                ", date=" + date +
                '}';
    }
}
