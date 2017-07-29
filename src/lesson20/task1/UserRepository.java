package lesson20.task1;


public class UserRepository {

    private User[] users = new User[10];


    public User save(User user) throws Exception {

        if (user == null)
            throw new BadRequestException("Can't save null user");
        try {

            findById(user.getId());
            throw new BadRequestException("User with id : " + user.getId() + " already exist");
        } catch (UserNotFoundException e) {
            System.out.println("User with id : " + user.getId() + " not found. Will be saved");
        }


        int index = 0;

        for (User us : users) {
            if (us == null) {
                users[index] = user;
                return users[index];
            }
            index++;
        }
        throw new InternalServelException("Not enough space to save user with id: " + user.getId());

    }

    public User update(User user) throws Exception {
        if (user == null)
            throw new BadRequestException("Can't save null user");
        findById(user.getId());


        int index = 0;

        for (User us : users) {
            if (us.getId().equals(user.getId())) {
                users[index] = user;
                return users[index];
            }
            index++;
        }

        throw new InternalServelException("Unexpected error");
    }

    public void delete(long id) throws Exception {
        findById(id);

        int index = 0;
        for (User us : users) {
            if (us.getId() == id) {
                users[index] = null;
                break;
            }
            index++;
        }

    }

    public User findById(long id) throws Exception {
        for (User user : users) {
            if (user != null && user.getId().equals(id))
                return user;
        }
        throw new UserNotFoundException("User with: " + id + " not found");

    }

    public UserRepository(User[] users) {
        this.users = users;
    }
}