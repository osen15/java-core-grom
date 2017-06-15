package lesson14.FinalHomeWork;


import java.util.Date;

public class User {

    private String name;
    private String lastName;
    private long id;
    private String password;
    private boolean login;
    private TypeOfUser typeOfUser;
    private User user;


    public User(String name, String lastName, long id, String password, boolean login, TypeOfUser typeOfUser) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        this.password = password;
        this.login = login;
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

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
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
