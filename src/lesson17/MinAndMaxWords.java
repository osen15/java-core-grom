package lesson17;

public class MinAndMaxWords {
    public static void main(String[] args) {
        String test = "qw we wewewe wewewe lkl wewewewewedfsdf";
        System.out.println(maxWord(test));
        System.out.println(minWord(test));

    }


    private static String maxWord(String input) {
        String[] words = input.split(" ");
        String max = words[0];
        for (String word : words) {
            if (word.length() > max.length()) {
                max = word;
            }
        }
        return max;
    }

    private static String minWord(String input) {
        String[] words = input.split(" ");
        String min = words[0];
        for (String word : words) {
            if (word.length() < min.length()) {
                min = word;
            }
        }
        return min;
    }
}
