package lesson9;

/**
 * Created by Oleg on 21.06.2017.
 */
public class UserRepository {



        private User[] users = new User[10];

        public User[] getUsers() {
            return users;
        }

        public User save(User user) {
            if (checkUser(user) && checkUserById(user) && checkArray_IsFullOrNot(users)) {
                int index = 0;
                for (User us : users) {
                    if (us == null) {
                        users[index] = user;
                        return user;
                    }
                    index++;
                }

            }
            return null;
        }

        private boolean checkUser(User user) {
            return user != null ? true : false;
        }


      private boolean checkUserById(User user) {
            for (User us : users) {
                if (us != null && user.getId() != us.getId());
                    return true;

            }
            return false;
        }

        private boolean checkArray_IsFullOrNot(User[] users) {
            int countPlaced = 0;
            for (User us : users) {
                if (us != null)
                    countPlaced++;

            }
            if (countPlaced == users.length - 1)
                return false;
            else

                return true;


        }

        public User update(User user) {
            int index = 0;
            for (User us : getUsers()) {
                if (us != null && user.equals(us)) {
                    getUsers()[index] = user;
                    return user;
                }
                index++;
            }
            return null;
        }

        public void delete(long id) {

            int index = 0;
            for (User user : users) {
                if (user != null && user.getId() == id) {
                    users[index] = null;
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





