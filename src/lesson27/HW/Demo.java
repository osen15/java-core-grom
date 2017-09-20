package lesson27.HW;

public class Demo {
    public static void main(String[] args) throws Exception {
        User user = new User(1002,"Oleg", "www");
        User user1 = new User(1002,"'Ann","'www");

        UserRepository userRepository = new UserRepository();
        System.out.println(userRepository.getUsers());

        userRepository.save(user);
        System.out.println(userRepository.getUsers());

        userRepository.save(user);
        System.out.println(userRepository.getUsers());

        userRepository.update(user1);
        System.out.println(userRepository.getUsers());

















    }











}
