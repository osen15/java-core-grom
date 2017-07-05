package lesson17;

import java.util.Arrays;

public class MostCoutedWord {
    public static void main(String[] args) {
        String test = " 2   df        df  &   &   &  &   && &  df     ";
        System.out.println((mostCountedWord(test)));
    }

    private static String mostCountedWord(String input) {
        if (input.equals("") || input == null || input.length() == 0) return null;
        String[] words = input.trim().split(" ");
        if (words.length == 2) return null;
        int[] res = new int[words.length];
        for (String word : words) {
            for (int i = 0; i < words.length; i++) {
                if (checkWord(words[i]) && checkWord(word) && !word.equals("")) {
                    if (word.equals(words[i]))
                        res[i]++;
                }
            }
        }
        int maxCount = 0;
        int max = res[0];
        for (int j = 0; j < res.length; j++) {
            if (res[j] > max) {
                max = res[j];
                maxCount = j;
            }
        }
        return checkWord(words[maxCount]) ? words[maxCount] : null;
    }

    private static boolean checkWord(String word) {   // перевірка символів на букву
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            if (!Character.isLetter(ch))
                return false;
        }
        return true;
    }
}

