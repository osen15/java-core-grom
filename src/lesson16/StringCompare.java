package lesson16;


import java.util.Arrays;

public class StringCompare {
    public static void main(String[] args) {
        System.out.println("abc" == "abc");
        System.out.println(new String("abc") == new String("abc"));
        System.out.println(new String("abc").equals(new String("abc")));
        System.out.println("abc".equals("abc"));


        String s1 = "test";
        String s2 = "test";

        // using intern
        String s3 = new String("pppp");
        String s4 = "pppp";
        System.out.println(s3 == s4);
        System.out.println(s3.intern() == s4);   //заганяє примусово об єкт в String pool


        // byte of String
        String str = "testStringVar";
        // Кожний символ має своє число, яке береться в ASCII Table
        System.out.println(Arrays.toString(str.getBytes()));   // перетворює String в байти для передачі з точки А в точку Б.
        System.out.println(new String(str.getBytes()));















    }


}
