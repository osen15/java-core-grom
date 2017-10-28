package lesson31.HW;

import java.util.*;

public class Solution {


    public Map<Character, Integer> countSymbols(String text) throws Exception {
        if (text == null) {
            throw new Exception("String is null");
        }

        SortedMap<Character, Integer> result = new TreeMap<>();
        char[] symbols = text.toLowerCase().toCharArray();
        convertToList(symbols).forEach(s -> result.merge(s, 1, (a, b) -> a + b));

        return result;
    }


    public Map<String, Integer> words(String text) throws Exception {
        if (text == null) {
            throw new Exception("text is null");
        }

        Map<String, Integer> result = new HashMap<>();

        String res = text.replaceAll("\\p{Punct}", " ");

        String[] words = res.toLowerCase().trim().split(" ");


        for (String word : words) {
            if (word.length() > 2 && checkSubString(word))
                result.merge(word, 1, (a, b) -> a + b);
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

    private List<Character> convertToList(char[] chars) {
        List<Character> characterList = new LinkedList<>();
        for (char ch : chars) {
            if (Character.isLetter(ch))
                characterList.add(ch);
        }
        return characterList;
    }
}



