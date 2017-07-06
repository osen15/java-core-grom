package lesson17;


public class MostCoutedWord {
    public static void main(String[] args) {
        String test = "d d     v       v          v          ";
        System.out.println((mostCountedWord(test)));
    }

    private static String mostCountedWord(String input) {
        if (input == null) return null;
        String[] words = input.trim().split(" ");
        int[] res = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (checkWord(words[i]) && checkWord(words[j]) && !words[i].equals("")) {
                    if (words[j].equals(words[i])) {
                        res[i]++;
                    }
                }
            }
        }
        int maxCount = 0;
        int max = res[0];
        for (int j = 0; j < res.length; j++) {
            if (res[j] > max) {
                max = res[j];
                maxCount = j;
            }
        }
        if (maxCount == 0 && max < 1)
            return null;
        else if (maxCount > 0)
            return words[maxCount];

        return words[maxCount];
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