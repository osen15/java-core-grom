package lesson27.HW;


import java.util.LinkedList;

public class UserRepository {

    private LinkedList<User> users = new LinkedList<>();


    public User save(User user) throws Exception {

        if (user == null) {
            throw new Exception("user can't be null");
        }
        if (users.size() == 0 || !users.contains(user)) {

            users.add(user);
        }
        return user;
    }


    public User update(User user) throws Exception {
        if (user == null) {
            throw new Exception("user can't be null");
        }


        users.replaceAll(user1 -> user1.equals(user) ? user : user1);


        return user;

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


        throw new Exception("User not was found");
    }


    public LinkedList<User> getUsers() {
        return users;
    }




 }










