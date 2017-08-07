package lesson22.repository;

public class UserRepository {
   private static User[] users = new User[10];


    public static User save(User user) {
        if (user == null)
            return null;
        if (findById(user.getId()) != null)
            return null;

        int countPlaced = 0;
        for (User us : users) {
            if (us != null)
                countPlaced++;
        }
        if (countPlaced > 9)
            return  null;




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

    public static User update(User user) {
        if (user == null)
            return null;

        if (findById(user.getId()) == null)
            return null;
        int index = 0;

        for (User us : users) {
            if (us != null && us.getId().equals(user.getId())) {
                users[index] = user;
                return users[index];

            }
            index++;
        }

        return null;
    }

    public static void delete(long id) {
        User user = findById(id);

        if (user == null)
            return;
        int index = 0;
        for (User us : users) {
            if (us.getId() == user.getId()) {
                users[index] = null;
                break;
            }
            index++;
        }


    }

    private static User findById(long id) {
        for (User user : users) {
            if (user != null && id == user.getId())
                return user;
        }
        return null;

    }

    public static User[] getUsers() {
        return users;
    }
}


















