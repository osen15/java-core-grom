package lesson9;

/**
 * Created by Oleg on 21.06.2017.
 */
public class UserRepository {

    User[] users = new User[10];

    public User[] getUsers() {
        return users;
    }

    public User save(User user) {
        if (user == null)
            return null;
        if (findById(user.getId()) != null)
            return null;
        int countPlaced = 0;
        for (User us : users) {
            if (us != null)
                countPlaced++;
        }
        int a = 0;

        for (User us : users) {
            if (us == null) {
                users[a] = user;
                break;
            }
            a++;
        }
        return user;
    }

    public User update(User user) {
        if (findById(user.getId()) == null)
            return null;
        int a = 0;

        for (User us : users) {
            if (us.getId().equals( user.getId())) {
                users[a] = user;
                break;
            }
            a++;
        }

        return user;
    }

    public void delete(long id) {
        User user = findById(id);

        if (user == null)
            return;
        int index = 0;
        for (User us : users) {
            if (us.getId().equals(user.getId())) {
                users[index] = null;
                break;
            }
            index++;
        }


    }

    private User findById(long id) {
        for (User user : users) {
            if (user != null && user.getId().equals(id))
                return user;
        }
        return null;

    }


}



