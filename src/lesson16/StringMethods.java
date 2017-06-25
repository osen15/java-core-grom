package lesson16;


import java.util.Arrays;

public class StringMethods {
    public static void main(String[] args) {


        String test = "someString";
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
        System.out.println(test.replaceFirst("me", "T"));

        // перевіряє чи містить відповідний String заданий String. Повертає true or false
        System.out.println(test.contains("e"));

        // повертає масив String, заміняє заданий символ комою, розділяє. Якщо нема такого символу, то вертає String
        System.out.println(Arrays.toString(test.split( "я")));

        // обрізає пробіли з початку і з кінця String
        System.out.println(test.trim());

        // повертає кусок String із заданої позиції, або кусок із заданої(включно) і кінцевої(не включно) позиції
        System.out.println(test.substring(3));
        System.out.println(test.substring(3,5));

        // всі букви переводить у великі або маленькі. Повертає String
        System.out.println(test.toUpperCase());
        System.out.println(test.toLowerCase());






        test.getBytes();






        test.equals("eeee");
        test.intern();




















    }

}
