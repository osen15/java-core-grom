package lesson9;

/**
 * Created by Oleg on 21.06.2017.
 */
public class User {


    private Long id;
    private String name;
    private String sessionId;


    public User(Long id, String name, String sessionId) {
        this.id = id;
        this.name = name;
        this.sessionId = sessionId;


    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getSessionld() {
        return sessionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!id.equals(user.id)) return false;
        if (!name.equals(user.name)) return false;
        return sessionId.equals(user.sessionId);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + sessionId.hashCode();
        return result;
    }
}

