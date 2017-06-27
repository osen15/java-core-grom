package lesson17;

import java.util.Arrays;

public class CountW {
    public static void main(String[] args) {
        String res = "! G G G g ] g l c 3 & *";
        System.out.println(countWords(res));

    }

    private static int countWords(String input) {
        if(input == null && input.toCharArray().length == 0)  return 0;
        int count = 0;
        String[] words = input.split(" ");
        for (String word : words) {
            if (!word.isEmpty() && word.matches("^[а-яА-ЯёЁa-ї-zA-Z]+$"))
                count++;
        }
        return count;
    }

}
