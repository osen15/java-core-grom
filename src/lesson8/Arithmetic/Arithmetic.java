package lesson8.Arithmetic;


import java.util.Arrays;

public class Arithmetic {


    boolean check(int[] array) {
        Arrays.sort(array);
        return array[0] + array[array.length - 1] > 100 ? true : false;
    }
}