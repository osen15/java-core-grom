package lesson17;

public class MinAndMaxWords {
    public static void main(String[] args) {
        String test = "Напишите методы для поиска самого длинного и самого короткого слова во входящем стринге";
        System.out.println(maxWord(test));
        System.out.println(minWord(test));
    }
    private static String maxWord(String input) {
        if (input.isEmpty()) return null;
        String string = input.replaceAll("\\pP", "");
        String[] words = string.split(" ");
        if (words.length > 0) {
            String max = words[0];
            for (String word : words) {
                if (word.length() > max.length() && word.matches("^[а-яА-ЯёЁa-zA-Z]+$")){
                    max = word;
                }
            }
            return max;
        }
        return null;
    }
    private static String minWord(String input) {
        if (input.isEmpty() ) return null;
        String string = input.replaceAll("\\pP", "");
        String[] words = string.split(" ");
        if (words.length > 0) {
            String min = words[0];
            for (String word : words) {
                if (word.length() < min.length() && word.matches("^[а-яА-ЯёЁa-zA-Z]+$")){
                    min = word;
                }
            }
            return min;
        }
        return null;
    }
}
