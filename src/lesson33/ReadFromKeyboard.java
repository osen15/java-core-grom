package lesson33;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromKeyboard {
    public static void main(String[] args) throws IOException {
        readKeyboardWithIOStreamFirstMethod();
        readKeyboardWithIOStreamSecondMethod();


    }


    private static void readKeyboardWithIOStreamFirstMethod() {

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        System.out.println("Enter your name");
        try {


            System.out.println("Hello, " + br.readLine());
        } catch (IOException e) {
            System.out.println("Reading from keyboard failed");
        } finally {
            try {
                reader.close();
                br.close();
            } catch (IOException e) {
                System.out.println("Closing stream failed");
            }
        }

    }

    private static void readKeyboardWithIOStreamSecondMethod() throws IOException {

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        System.out.println("Enter your name");
        try {


            System.out.println("Hello, " + br.readLine());
        } catch (IOException e) {
            System.out.println("Reading from keyboard failed");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);

        }
    }

}



