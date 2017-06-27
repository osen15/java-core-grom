package lesson17;

import java.util.Arrays;

public class CountW {
    public static void main(String[] args) {
        String res = "! % @ ^ ї S m";
        System.out.println(countWords(res));

    }

    private static int countWords(String input) {
        if(input == null)
            return 0;
        int count = 0;
        String[] words = input.split(" ");
        for (String word : words) {
            if (!word.isEmpty() && word.matches("^[а-яА-ЯёЁa-ї-zA-Z]+$"))
                count++;
        }
        return count;
    }

}
