package lesson31.HW;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {


    public Map<Character, Integer> countSymbols(String text) throws Exception {

        if (text == null) {
            throw new Exception("String is null");
        }

        SortedMap<Character, Integer> result = new TreeMap<>();


        Integer count = 0;

        char[] letters = text.toCharArray();

        for (Character ch1 : letters) {
            for (char ch2 : letters) {
                if (Character.isLetter(ch1) && Character.toLowerCase(ch1) == Character.toLowerCase(ch2)) {
                    count++;
                    result.put(Character.toLowerCase(ch1), count);
                }
            }
            count = 0;
        }
        return result;

    }

    public Map<String, Integer> words(String text) throws Exception {
        if (text == null) {
            throw new Exception("text is null");
        }
        Integer count = 0;
        Map<String, Integer> result = new TreeMap<>();
        String res = text.replaceAll("\\p{Punct}","");

        String[] words = res.toLowerCase().trim().split(" ");

        for (String word1 : words) {
            for (String word2 : words) {

                if (word1.length() > 2 && checkSubString(word1) && word1.equals(word2)) {
                    count++;
                    result.put(word1, count);
                }

            }
            count = 0;
        }
        return result;

    }

    private boolean checkSubString(String string) throws Exception {
        if (string == null) {
            throw new Exception("string is null");
        }

        char[] word = string.trim().toCharArray();
        for (char ch : word) {
            if (!Character.isLetter(ch)) {
                return false;
            }


        }

        return true;
    }


}



