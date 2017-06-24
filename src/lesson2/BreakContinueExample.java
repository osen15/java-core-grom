package lesson2;

/**
 * Created by Masja on 22.03.2017.
 */
public class BreakContinueExample {
    public static void main(String[] args) {
        int test = 10;


        // break example
       /* while (test > 0){
            System.out.println(test);
            System.out.println("...");
            test--;
            break;

        }*/

        // continue example
        while (test > 0) {
            System.out.println(test);
            if (test == 5)
                continue;
            System.out.println("...");
            test--;
        }
        System.out.println("done");
    }
}
