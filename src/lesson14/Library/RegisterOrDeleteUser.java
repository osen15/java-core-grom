package lesson14.Library;

/**
 * Created by Oleg on 07.06.2017.
 */
public class RegisterOrDeleteUser implements RegOrDelUser {
    User user;

    public RegisterOrDeleteUser(User user) {
        this.user = user;
    }

    @Override
    public User regUser(User user, User user1) {
        if (user == null)
            user = user1;
        return user;
    }

    @Override
    public User delUser(User user, long id) {
        return user.getId() == id ? null : user;
    }


}