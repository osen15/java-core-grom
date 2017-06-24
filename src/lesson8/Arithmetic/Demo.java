package lesson8.Arithmetic;


public class Demo {
    public static void main(String[] args) {
        int[] array = {100, 3, 2, 8};
        Adder adder = new Adder();
        adder.add(4, 6);
        adder.check(array);
        System.out.println(adder.check(array));

    }
}
