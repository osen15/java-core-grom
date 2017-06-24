package lesson4;

public class SumMethodPractice {
    public static void main(String[] args) {

        System.out.println(compareSums(1, 2, 1, 1));
    }

    public static boolean compareSums(int a, int b, int c, int d) {

        return (sum(a, b) > sum(c, d));

    }

    public static long sum(int from, int to) {
        long summa = 0;
        for (long i = (long)from; i <= (long)to; i++) {
            summa += i;
        }
        return summa;
    }
}

