package lesson4;

/**
 * Created by Masja on 26.03.2017.
 */
public class FindDivCountPractice {
    public static void main(String[] args) {

        System.out.println(findDivCount((short) 2, (short) 4, 2));

    }

    public static int findDivCount(short a, short b, int n) {
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (a % n == 0) {
                count++;
            }

        }
        return count;
    }
}