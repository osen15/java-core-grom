package lesson14.FinalHomeWork;


import java.util.Date;

public class User {

    String name;
    String lastName;
    long id;
    String password;

    TypeOfUser typeOfUser;
    User user;


    public User(String name, String lastName, long id, String password, TypeOfUser typeOfUser) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        this.password = password;

        this.typeOfUser = typeOfUser;
    }

    public TypeOfUser getTypeOfUser() {
        return typeOfUser;
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

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                ", typeOfUser=" + typeOfUser +
                '}';
    }
}
