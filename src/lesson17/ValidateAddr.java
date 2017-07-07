package lesson17;

import java.util.Arrays;

public class ValidateAddr {
    public static void main(String[] args) {
        String test = "https://gromcode.com";
        System.out.println(validate(test));

    }

    private static boolean validate(String address) {
        if (address == null)
            return false;
        String[] domens = new String[]{".com", ".org", ".net"};
        if (checkAddressOnWhiteSpace(address) && address.substring(0, 7).equals("http://") && checkWord(address.substring(8, address.length() - 5))
                || checkAddressOnWhiteSpace(address) && (address.substring(0, 8).equals("https://")) && checkWord(address.substring(9, address.length() - 5))) {
            for (String domen : domens) {
                if (address.substring(address.length() - 4, address.length()).equals(domen)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkWord(String word) {   // перевірка символів на букву і цифру
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            if (!Character.isLetterOrDigit(ch))
                return false;
        }
        return true;
    }

    private static boolean checkAddressOnWhiteSpace(String address) {   //метод перевіряє на вайтспейс і чи масив з стрінгів менший за 2
        String[] simbols = address.split("");
        if (simbols.length > 2) {
            for (String simb : simbols) {
                if (Character.isWhitespace(simb.charAt(0)))
                    return false;
            }
        } else if (simbols.length <= 2)
            return false;
        return true;
    }
}