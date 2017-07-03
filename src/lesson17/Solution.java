package lesson17;



public class Solution {
    public static void main(String[] args) {
        String test = "sq'wwet2 1111 gfg er1 vbnmm  gfgf";
        System.out.println(maxWord((test)));
        System.out.println(minWord(test));
    }
    private static String maxWord(String input) {
        if (input == null) return null;  // на null
        String[] words =input.trim().split(" ");
        String max = words[0];
        for (String word : words) {
            if (checkWord(word) && word.length() > max.length())
                max = word;
        }
        return max;
    }
    private static String minWord(String input) {
        if (input == null) return null;
        String[] words = input.trim().split(" ");
        String min = (words)[0];

        for (String word : words) {
            if (!word.equals("") && checkWord(word) && word.length() < min.length())
                min = word;
        }
        return min;
    }

    private static boolean checkWord(String word) {   // перевірка символів на букву
       char[] chars = word.toCharArray();
       for (char ch : chars){
           if (!Character.isLetter(ch))
               return  false;
       }
       return  true;

    }
}
