package lesson17;
public class CountW {
    public static void main(String[] args) {
        String res = "wer wwr www";
        System.out.println(countWords(res));

    }

    private static int countWords(String input) {
        int count = 0;
        String[] words = input.split(" ");
        for (String word : words) {
            if (!word.isEmpty())
                count++;
        }
        return count;
    }

}
