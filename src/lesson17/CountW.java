package lesson17;


import java.util.Arrays;

public class CountW {
    public static void main(String[] args) {
        String res = "Напишите метод! countWords для слов во входящем стринге.";
        System.out.println(countWords(res));
    }

    private static int countWords(String input) {
        if(input.isEmpty())  return 0;
        int count = 0;
        String string =input.replaceAll("\\pP", "");
        String[] words = string.split(" ");
        for (String word : words) {
            if (word.matches("^[а-яА-ЯёЁa-zA-Z]+$"))
                count++;
        }
        return count;
    }
}
