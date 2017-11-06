package exercises.printTextFromTextFileToConsole;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws  Exception {

        Solution solution = new Solution();
        solution.printTextFromTextFile("C:/Test.txt");


    }


    public void printTextFromTextFile(String placeOfFile) throws Exception {
        try {
            FileInputStream fileInputStream = new FileInputStream(placeOfFile);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String strLine;

            while ((strLine = bufferedReader.readLine()) != null) {
                System.out.println(strLine);

            }
        } catch (IOException e) {
            System.out.println("ERROR");
        }
    }
}
