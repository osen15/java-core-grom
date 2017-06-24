package lesson2;

/**
 * Created by Masja on 24.03.2017.
 */
public class SumOfNumbers2 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        while (i <=1000){
            sum += i;
            i++;
        }
        int d = sum / 1234;
        int m =sum % 1234;
        System.out.println(m > d);
    }
}
