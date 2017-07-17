package lesson18.HW;


import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {
        String test = "ss 5.6 6";
        System.out.println(Arrays.toString(findNumbers(test)));

    }

    private static int[] findNumbers(String text) {
        if (text == null) return null;
        int index = 0;
        int[] res = new int[lenghtArrayOfInt(text)];
        for (String string : text.split(" ")) {
            if (checkObj(string)) {
                res[index] = Integer.parseInt(string);
                index++;
            } else System.out.println(string + " not a number");
        }
        return res;
    }

    private static int lenghtArrayOfInt(String text) {
        if (text == null) return 0;
        int count = 0;
        for (String string : text.split(" ")) {
            if (checkObj(string))
                count++;
        }

        return count;
    }

    private static boolean checkObj(String number) {
        char[] chars = number.toCharArray();
        for (char ch : chars) {
            if (!Character.isDigit(ch))
                return false;
        }
        return true;
    }

}

