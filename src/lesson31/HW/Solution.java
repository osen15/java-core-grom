package lesson31.HW;

import java.util.*;

public class Solution {


    public Map<Character, Integer> countSymbols(String text) throws Exception {
        if (text == null) {
            throw new Exception("String is null");
        }
        int count = 1;


        SortedMap<Character, Integer>  result = new TreeMap<>();
        char[] symbols = text.toLowerCase().toCharArray();
        for (Character ch : symbols) {
            if (Character.isLetter(ch)) {
                if (!result.containsKey(ch)) {
                    count = 1;
                }
                result.put(ch, count++);
            }
        }
        return result;
    }


    public Map<String, Integer> words(String text) throws Exception {
        if (text == null) {
            throw new Exception("text is null");
        }
        int count = 0;
        Map<String, Integer> result = new TreeMap<>();
        String res = text.replaceAll("\\p{Punct}", " ");
        String[] words = res.toLowerCase().trim().split(" ");

        for (String word : words) {
            if (word.length() > 2 ) {
                if (!result.containsKey(word)){
                    count = 1;
                }
                result.put(word, count++);
            }
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



