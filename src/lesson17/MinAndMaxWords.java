package lesson17;

public class MinAndMaxWords {
    public static void main(String[] args) {
        String test = " sq'w wet      ";
        System.out.println(maxWord(test));
       // System.out.println(minWord(test));

    }


    private static String maxWord(String input) {
        if (input.trim().isEmpty() || input == null) return null;
        String string = input.replaceAll("\\pP", "");
        String[] words = string.trim().split(" ");
        if (words.length == 0) return null;
        String max = words[0];
        for (String word : words) {
            if (!word.isEmpty() && word.length() > max.length()  ) {
                max = word;
            }
        }
        return max;
    }

    private static String minWord(String input) {
        if (input.trim().isEmpty() || input == null) return null;
        String[] words = input.trim().split(" ");
        if (words.length == 0) return  null;
        String min = words[0];
        for (String word : words) {
            if (!word.isEmpty() && word.length() < min.length()) {
                min = word;
            }
        }
        return min;
    }
}
