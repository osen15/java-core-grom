package lesson27;


import java.util.ArrayList;

public class UserRepository {

    private ArrayList<User> users = new ArrayList<>();


    public User save(User user) throws Exception {

        if (user == null) {

            throw new Exception("user can't be null");
        }

        if (users.size() == 0 || !findById(user.getId()).equals(user)) {

            users.add(user);
        }
        return user;
    }


    public User update(User user) throws Exception {
        if (user == null) {
            throw new Exception("user can't be null");
        }

        int index = 0;

        for (User us : users) {
            if (us != null && us.getId().equals(user.getId())) {
                users.remove(us);
                users.add(index, user);
                return user;
            }
            index++;
        }
        throw new Exception("user was not found");
    }


    public void delete(long id) throws Exception {
        users.remove(findById(id));
    }

    public User findById(long id) throws Exception {
        int count = 0;
        for (User user : users) {
            if (user != null && user.getId().equals(id)) {
                return users.get(count);
            }
            count++;
        }

        throw new Exception(id + " was not found");
    }


    public ArrayList<User> getUsers() {
        return users;
    }
}


