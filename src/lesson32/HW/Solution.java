package lesson32.HW;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {


    public void readNumbers() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 4;
        while (n <= 0 ) {


            System.out.println("enter the numbers: ");
            String enterDg = br.readLine();
            String[] digits = enterDg.split(" ");
            int sum = 0;


            for (String el : digits) {
                if (Integer.parseInt(el) > 100)
                    System.out.println("“Your numbers are wrong. You have" + n-- + "attempts to try again”");


                sum = sum + Integer.parseInt(el);


            }
            System.out.println(sum);


        }

    }
}
