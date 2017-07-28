package lesson9;

/**
 * Created by Oleg on 21.06.2017.
 */
public class UserRepository {

    private User[] users = new User[10];


    private User findById(long id) {
        for (User user : users) {
            if (user != null && user.getId() == id) {
                return user;
            }
        }
        return null;
    }


    public User save(User user) {
        if (user == null) {
            return null;
        }
        int count = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                count++;
            }
        }
        if (count == 0) {
            return null;
        }

        for (int i = 0; i < users.length; i++) {
            if (users[i] == user) {
                return null;
            }
            if (users[i] == null) {
                users[i] = user;
                return users[i];
            }
        }
        return null;
    }

    public User update(User user) {
        if (user == null) {
            return null;
        }

        User findUserById = this.findById(user.getId());
        if (findUserById == null) {
            return null;
        }
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == user.getId()) {
                return users[i] = user;
            }
        }
        return null;
    }


    public void delete(long id) {

        int index = 0;
        User user = findById(id);
        for (User us : users) {
            if (us == user) {
                users[index] = null;
                break;
            }
            index++;
        }
    }

    public User getFindUserById(long id) {
        return findById(id);
    }

    public User[] getUsers() {
        return users;
    }
}