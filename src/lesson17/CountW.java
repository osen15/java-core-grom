package lesson17;



public class CountW {
    public static void main(String[] args) {
        String res = "Один two три чотири       !!!@!#@#   FIVE        ";
        System.out.println(countWords(res));
    }

    private static int countWords(String input) {
        if(input == null)  return 0;
        int count = 0;
        String string = input.trim();
        String[] words = string.split(" ");
        for (String word : words) {
            if (word.matches("^[а-яА-ЯёЁa-zA-Z]+$"))
                count++;
        }
        return count;
    }
}
