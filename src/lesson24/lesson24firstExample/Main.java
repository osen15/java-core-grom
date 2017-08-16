package lesson24.lesson24firstExample;

public class Main {


    private static void demo() {


        User user = new User(11);
        Solution solution = new Solution("test");
        Demo<User> demo1 = new Demo<>();
        demo1.print(user);
        Demo<Solution> demo2 = new Demo<>();
        demo2.print(solution);

    }

    public static void main(String[] args) {
        demo();

    }

}
