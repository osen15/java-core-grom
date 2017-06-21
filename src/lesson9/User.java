package lesson9;

/**
 * Created by Oleg on 21.06.2017.
 */
public class User {


    private Long id;
    private String name;
    private String sessionld;


    public User(Long id, String name, String sessionld) {
        this.id = id;
        this.name = name;
        this.sessionld = sessionld;


    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getSessionld() {
        return sessionld;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!id.equals(user.id)) return false;
        if (!name.equals(user.name)) return false;
        return sessionld.equals(user.sessionld);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + sessionld.hashCode();
        return result;
    }
}

