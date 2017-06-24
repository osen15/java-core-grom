package lesson5;

public class PersentByElementOfArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 8, 0, 5};
        System.out.println(persentByElement(arr,6));
    }
    static double persentByElement(int[] array, double n) {

                for (int i = 0; i < array.length; i++) {
                    if (i == n) {
                        n = array[i] + (array[i] * 0.1);
                    }
                }
        return n;
    }
}