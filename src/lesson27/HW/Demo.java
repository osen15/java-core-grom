package lesson27.HW;

public class Demo {
    public static void main(String[] args) throws Exception {
        User user1 = new User(1001,"Oleg", "www");
        User user2 = new User(1002,"'An","'w");
        User user3 = new User(1003,"'A","'ww");
        User user4 = new User(1002,"'Ann","'uuu");


        UserRepository userRepository = new UserRepository();
      //  System.out.println(userRepository.getUsers());

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);


          System.out.println(userRepository.getUsers());

      //  userRepository.Save(user);
      //  System.out.println(userRepository.getUsers());

        System.out.println(userRepository.update(user4));
        System.out.println(userRepository.getUsers());

















    }











}
