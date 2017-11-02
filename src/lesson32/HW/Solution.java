package lesson32.HW;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    private int n = 3;

    public void readNumbers() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int count =0;

        while (n >= 0) {


            System.out.println("enter the numbers: ");
            String enterDg = br.readLine();
            String[] digits = enterDg.split(" ");


            for (String el : digits) {
                sum = sum + Integer.parseInt(el);


                if (Integer.parseInt(el) > 100 && n > 0) {
                    System.out.println("“Your numbers are wrong. You have " + n + " attempts to try again”");
                    break;

                }
                count++;
            }
            if (count ==10)
                break;
            if (n == 0)
                break;
            n--;


        }

        if (n == 0)
            System.out.println(" “Your numbers are wrong. Number of attempts exceeded”");

        else System.out.println(sum);

    }


}
