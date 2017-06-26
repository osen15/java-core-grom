package lesson17;

import java.util.Arrays;

public class MostCoutedWord {
    public static void main(String[] args) {
        String test = "as sd";
        System.out.println((mostCountedWord(test)));
    }
    private static String mostCountedWord(String input) {
        String[] strings = input.split(" ");
        int[] res = new int[strings.length];
        for (String string : strings) {
            for (int i = 0; i < strings.length; i++) {
                if (string.equals(strings[i]))
                    res[i]++;
                else return null;
            }
        }
        int maxIndex = 0;
        int max = res[0];
        for (int j = 0; j < res.length - 1; j++) {
            if (res[j] > max) {
                max = res[j];
                maxIndex = j;
            }
        }
        return strings[maxIndex];
    }
}
