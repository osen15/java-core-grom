package lesson16;


import java.util.Arrays;

public class StringMethods {
    public static void main(String[] args) {


        String test = "someStringExample";
        // вертає true або false в залежності від того порожній String  чи ні.
        System.out.println(test.isEmpty());
        // єдиний випадок коли String порожній
        System.out.println("".isEmpty());

        // повертає довжину String
        System.out.println(test.length());

        // повертає String на заданій позиції
        System.out.println(test.charAt(2));

        // повертає String після заміни. Якщо такого String нема то повертаэ без змін
        System.out.println(test.replace("me", "T"));

        // String regex = {a - z};
        test = "someString";
        System.out.println(test.replaceAll("me", "T"));
        System.out.println(test);
        // перевіряє чи містить відповідний String заданий String. Повертає true or false
        System.out.println(test.contains("mes"));
        System.out.println(test);

        // повертає масив String, заміняє заданий символ комою, розділяє. Якщо нема такого символу, то вертає String
        String phrase = "Hello there guys";
        System.out.println(Arrays.toString(phrase.split( " ")));


        // обрізає пробіли з початку і з кінця String
        System.out.println(" test a".trim());

        // повертає кусок String із заданої позиції, або кусок із заданої(включно) і кінцевої(не включно) позиції
        System.out.println(phrase.substring(5));
        System.out.println(phrase.substring(5,10).trim());

        // всі букви переводить у великі або маленькі. Повертає String
        System.out.println(test.toUpperCase());
        System.out.println(test.toLowerCase());






        test.getBytes();
        test.equals("eeee");
        test.intern();




















    }

}
