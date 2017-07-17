package lesson19;

/**
 * Created by Masja on 15.07.2017.
 */
public class RunTimeExceptionExample {
    public static void main(String[] args) {
        //arithmeticExeption
        arithmeticExeption(2);
        try {
            arithmeticExeption(0);
        }catch (Exception e){
            System.out.println("something wrong");
        }
        npe(new Object());
        npe(null);



    }
    private  static  void arithmeticExeption(int a){
        System.out.println(10/a);
    }
    private  static  void npe(Object object){
        if (object != null) {
            System.out.println(object.hashCode());
        }
    }
}
