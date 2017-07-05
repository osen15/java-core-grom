package lesson17;


public class Solution {
    public static void main(String[] args) {
        String test = "1 re    ";
        System.out.println(maxWord((test)));
        System.out.println(minWord(test));
    }

    private static String maxWord(String input) {
        if (input.isEmpty() || input == null) return null; // перевірка на порожній рядок і null
        String[] words = input.trim().split(" "); // обрізаємо з країв і розбиваємо на слова
        String max = checkWordZero(words, words[0]);
        for (String word : words) {
            if (checkWord(word) && !word.equals("")) {
                if (word.length() > 0 && word.length() > max.length()) {
                    max = word;
                }
                if (words.length > 0 && words.length == 1) {
                    max = word;
                }
            }
        }
        return max;
    }

    private static String minWord(String input) {
        if (input.equals("") || input == null) return null;
        String[] words = input.trim().split(" ");
        String min = checkWordZero(words, words[0]);
        for (String word : words) {
            if (checkWord(word) && !word.equals("")) {
                if (word.length() > 0 && word.length() < min.length()) {
                    min = word;
                }
                if (word.length() > 0 && words.length == 1) {
                    min = word;
                }
            }
        }
        return min;
    }

    private static boolean checkWord(String word) {   // перевірка символів на букву
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            if (!Character.isLetter(ch))
                return false;
        }
        return true;
    }

    private static String checkWordZero(String[] words, String word1) { // метод заміни числа на слово, якщо є таке.
        for (String word : words) {
            if (checkWord(word) && !checkWord(word1) && !word.equals("") && !word1.equals("")) {
                word1 = word;
                return word1;
            }
            if (checkWord(word) && checkWord(word1) && !word.equals("") && !word1.equals(""))
                return word1;
        }
        return null;
    }
}
