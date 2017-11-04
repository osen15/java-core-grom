package lesson32.HW;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    private int n = 3;

    public void readNumbers() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int count = 0;

        while (n >= 0) {


            System.out.println("enter the numbers: ");
            String enterDg = br.readLine();
            String[] digits = enterDg.split(" ");

            if (digits.length == 10) {
                for (String el : digits) {

                    if (!validateOnDigit(el) || validateOnDigit(el) &&Integer.parseInt(el) > 100) {

                        break;

                    }
                    sum = sum + Integer.parseInt(el);
                    count++;
                }

            }
            if (count == 10 || n == 0)
                break;
            System.out.println("“Your numbers are wrong. You have " + n-- + " attempts to try again”");

        }

        if (n == 0)
            System.out.println(" “Your numbers are wrong. Number of attempts exceeded”");

        else System.out.println(sum);
        br.close();

    }


    private boolean validateOnDigit(String string){
        char[] chars = string.toCharArray();
        for (char ch : chars){
            if (!Character.isDigit(ch))
                return false;
        }
        return true;
    }


}
