package lesson17;


public class Solution {
    public static void main(String[] args) {
        String test = "1";
        System.out.println(maxWord((test)));
        System.out.println(minWord(test));
    }

    private static String maxWord(String input) {
        if (input.isEmpty() || input == null) return null;  // на null
        String[] words = input.trim().split(" ");
        if (words.length == 0) return null;
        String max = words[0];
        for (String word : words) {
            if (checkWord(word)) {
                if (word.length() > 0 && word.length() > max.length()) {
                    max = word;
                    return max;
                }
                if (words.length > 0 && words.length == 1 ) {
                    max = word;
                    return max;
                }
            }
        }
        return "ERROR";
    }

    private static String minWord(String input) {
        if (input.equals("") || input == null) return null;
        String[] words = input.trim().split(" ");
        if (words.length == 0) return null;
        String min = (words)[0];
        for (String word : words) {
            if (checkWord(word)) {
                if (word.length() > 0 && word.length() < min.length()) {
                    min = word;
                    return min;
                }
                if (word.length() > 0 && words.length == 1){
                    min = word;
                    return min;
                }
            }
        }
        return "ERROR";
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
