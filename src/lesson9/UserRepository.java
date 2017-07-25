package lesson9;

/**
 * Created by Oleg on 21.06.2017.
 */
public class UserRepository {

    User[] users = new User[10];

    public User[] getUsers() {
        return users;
    }

    public User save(User user) throws UserNotFoundException, BadRequestException {
        if (user == null)
            throw new NullPointerException("user is null");
        findById(user.getId());

        int count = 0;

        for (User us : users) {
            if (us == null) {
                users[count] = user;
                break;
            }
            count++;
        }
        throw new BadRequestException();

    }

    public User update(User user) throws UserNotFoundException, InternalServerError {
        if (user == null)
            throw new NullPointerException();
        int index = 0;

        for (User us : users) {
            if (us.getId().equals(user.getId())) {
                users[index] = user;
                break;
            }
            index++;
        }

        throw new InternalServerError();
    }

    public void delete(long id) throws UserNotFoundException, InternalServerError {
        User user = findById(id);

        int index = 0;
        for (User us : users) {
            if (us.getId().equals(user.getId())) {
                users[index] = null;
                break;
            }
            index++;
        }

        throw new InternalServerError();


    }

    private User findById(long id) throws UserNotFoundException {
        for (User user : users) {
            if (user != null && user.getId() == id)
                return user;
        }
        throw new UserNotFoundException();

    }

    private class BadRequestException extends Exception {

    }

    private class UserNotFoundException extends Exception {

    }

    private class InternalServerError extends Exception {

    }


}



