package lesson32.HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    private int n = 3;

    void readNumbers() throws Exception {
        try {


            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            double sum = 0;
            int count = 0;

            while (n >= 0) {


                System.out.println("enter the numbers: ");
                String enterDg = br.readLine();
                String[] digits = enterDg.split(" ");

                if (digits.length == 10) {
                    for (String el : digits) {

                        if (!validateOnDigit(el) || Double.parseDouble(el) > 100) {

                            break;

                        }
                        sum += Double.parseDouble(el);
                        count++;
                    }

                }
                if (count == 10 || n == 0)
                    break;
                System.out.println("“Your numbers are wrong. You have " + n-- + " attempts to try again”");

            }

            if (n == 0) {
                System.out.println(" “Your numbers are wrong. Number of attempts exceeded”");

            } else System.out.println(sum);
        }
        catch (IOException e){
            System.out.println("ERROR");

        }



    }


    private boolean validateOnDigit(String string) {
        char[] chars = string.toCharArray();

        if (!validateCharArray(chars))
            return false;

        int count = 0;

        for (char ch : chars) {
            if (!Character.isDigit(ch) || ch != '.') {
                count++;
            } else return false;
        }

        return true;
    }

    private boolean validateCharArray(char[] chars) {
        int count = 0;
        for (char aChar : chars) {

            if (chars[0] == '.' || chars[chars.length - 1] == '.') {
                return false;
            }
            if (aChar == '.')
                count++;
            else if (count > 1)
                return false;
        }
        return true;
    }


}
