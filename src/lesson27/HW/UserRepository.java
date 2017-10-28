package lesson27.HW;


import java.util.LinkedList;
import java.util.Objects;
import java.util.function.UnaryOperator;

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

    public User updateUnaryOpEx(User userToReplace) throws Exception {
        if (userToReplace == null) {
            throw new Exception("user can't be null");
        }
        users.replaceAll(new UnaryOperator<User>() {
            @Override
            public User apply(User user) {
                if (Objects.equals(user.getId(), userToReplace.getId()))
                    return userToReplace;
                return user;

            }


        });

     return userToReplace;
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










