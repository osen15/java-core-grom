package lesson15.cast;

/**
 * Created by Oleg on 21.06.2017.
 */
public class Demo {
    public static void main(String[] args) {
        InternetProvider provider = (InternetProvider) test();
        FoodProvider foodProvider = (FoodProvider) testFood();


        System.out.println(provider);

    }
    private   static Object test(){
       //logic

        return new InternetProvider();

        }
   private static Object testFood() {
        //logic

        return new FoodProvider();


    }






}
