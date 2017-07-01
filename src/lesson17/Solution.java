package lesson17;



public class Solution {
    public static void main(String[] args) {
        String test = "sq'wwet1 1111 gfg er1 vbnmm  gfgf";
        System.out.println(maxWord((test)));
        System.out.println(minWord(test));
    }
    private static String maxWord(String input) {
        if (input.trim().isEmpty() || input == null) return null;  // обрізаємо рядок і перевіряємо чи порожній і на null
        String[] words = (input + " ").trim().split("\\p{P}?[ \\t\\n\\r]+"); // виключаємо всі розділові знаки і пробіли
        if (words.length == 0) return null;  // перевірка довжини масива
        String max = checkWords(words)[0];
        for (String word : words) {
            if (word.length() > max.length())
                max = word;
        }
        return max;
    }
    private static String minWord(String input) {
        if (input.trim().isEmpty() || input == null) return null;
        String[] words = (input + " ").trim().split("\\p{P}?[ \\t\\n\\r]+");
        if (words.length == 0) return null;
        String min = checkWords(words)[0];

        for (String word : words) {
            if (word.length() < min.length())
                min = word;
        }
        return min;
    }

    private static String[] checkWords(String[] words) {   // перевірка символів на букву
        for (int i = 0; i < words.length; i++) {
            for (char letter : words[i].toCharArray()) {
                if (!Character.isLetter(letter))
                    words[i] = String.valueOf("".isEmpty());
            }
        }
        return words;

    }
}
