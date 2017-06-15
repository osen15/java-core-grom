package lesson14.FinalHomeWork;


import java.util.Date;

public class UserRepository {
  private   User user1 = new User("A","Q",1001,"123",false, TypeOfUser.ADMIN);
  private   User user2 = new User("A","Q",1002,"123",false, TypeOfUser.LIBRARIAN);
  private   User user3 = new User("A","Q",1003,"123",false, null);
  private   User user4 = null;
  private   User user5 = null;
  private   User[] users = {user1, user2, user3, user4, user5};


    public void regUser(User user, User user1) {
        if (user == null && user1 != null) {
            user = user1;
            System.out.println(user);
        } else System.out.println("  ");
    }

    public void delete(long id) {

        int index = 0;
        for (User user : users) {
            if (user != null && findById(id) == findById(user.getId())) {
                users[index] = null;
                break;
            }
            index++;
        }
    }

    public User[] addUser(User user) {
        int index = 0;
        checkArray();
        for (User user1 : users) {
            if (user1 == null) {
                users[index] = user;
                break;
            }
            index++;
        }

        return users;
    }

    public long findById(long id) {
        for (User user : getUsers()) {
            if (user != null && user.getId() == id)
                return id;
        }
        return 0;
    }


    public boolean login(long id) {
        for (User user : users) {
            if (user != null && user.getId() == id)
                user.setLogin(true);

                return user.isLogin();
        }
        return false;
    }


    public void logout(User user) {
        if (login(user.getId()))
            user.setLogin(false);

    }


    public User[] getUsers() {
        return users;
    }

    private User[] checkArray() {
        int index = 0;
        for (User user : users) {
            if (user != null)
                index++;
        }
        if (index == users.length - 1)
            return null;

        else
            return users;
    }


}








