package lesson9;

import java.util.Arrays;

/**
 * Created by Oleg on 21.06.2017.
 */
public class Demo {
    private static   UserRepository userRepository;
    public static   UserRepository getInstanceUser() {
        if (userRepository == null)
            userRepository = new UserRepository();
        return userRepository;
    }

    public static void main(String[] args) {
        User user = new User(1001,"Oleg", "www");
        User user1 = new User(1001,"'Oleg","'www");
      //  Sys.out.println(getInstanceUser().Save(user));
     //   Sys.out.println(Arrays.deepToString(getInstanceUser().getUsers()));
     //   Sys.out.println(getInstanceUser().update(user));
      //  Sys.out.println(Arrays.deepToString(getInstanceUser().getUsers()));
       // getInstanceUser().delete(1001);
      //  Sys.out.println(Arrays.deepToString(getInstanceUser().getUsers()));




    }



}
