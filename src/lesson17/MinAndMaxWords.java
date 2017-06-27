package lesson17;

public class MinAndMaxWords {
    public static void main(String[] args) {
        String test = "qw we wewewe wewewe l";
        System.out.println(maxWord(test));
        System.out.println(minWord(test));

    }


    private static String maxWord(String input) {
        if (input.isEmpty()) return null;
        String string =input.replaceAll("\\pP", "");
        String[] words = string.split(" ");
        String max = words[0];
        for (String word : words) {
            if (word.length() > max.length() && word.matches("^[а-яА-ЯёЁa-zA-Z]+$")) {
                max = word;
            }
        }
        return max;
    }

    private static String minWord(String input) {
        if (input.isEmpty()) return null;
        String string =input.replaceAll("\\pP", "");
        String[] words = string.split(" ");
        String min = words[0];
        for (String word : words) {
            if (word.length() < min.length()) {
                min = word;
            }
        }
        return min;
    }
}
