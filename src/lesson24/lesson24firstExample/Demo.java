package lesson24.lesson24firstExample;


public class Demo<T> {


    //  private printUser(User user){
    //
    //print
    //
    // }


    // private printSolution(Solution solution){
    //
    //prnt
    //
    // }

    // private printChanel(Chanel chanel){
    //
    //print
    //
    // }


    public void print(T t) {
        System.out.println(t);
    }


    //  private static void calculatePrice(FirstOrder firstOrder){
    //      Sys.out.println(firstOrder.getPrice());


    // private static   void calculatePrice(SecondOrder secondOrder){
    //     Sys.out.println(secondOrder.getPrice());

    private static void calculatePrice(AbstractOrder abstractOrder) {
        System.out.println(abstractOrder.getPrice());                      // добре коли э клас предок


    }


    public static void main(String[] args) {
        calculatePrice(new FirstOrder());
        calculatePrice(new SecondOrder());


    }

}





