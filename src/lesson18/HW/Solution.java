package lesson18.HW;


import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String test = "78 3.3";
        System.out.println(Arrays.toString(findNumbers(test)));

    }

    private static int[] findNumbers(String text) {
        if (text == null) return null;
        int index = 0;
        int[] res = new int[lenghtArrayOfInt(text)];
        for (String word :  text.split(" ") ) {
            try {
                res[index] = Integer.parseInt(word);
                index++;
            } catch (Exception e) {
                System.out.println(word + " not a number");
            }
        }

        return res;
    }
    private static int lenghtArrayOfInt(String text) {
        if (text == null) return 0;
        int count = 0;
        for (String word : text.split(" ")) {
            try {
                Integer.parseInt(word);
                count++;
            } catch (Exception ignored) {

            }
        }

        return count;
    }
}