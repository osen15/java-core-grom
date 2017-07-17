package lesson18.exersice2;

public class Converter {
    public static void main(String[] args) {
        System.out.println(intToString(111231));
        System.out.println(StringToInt("11"));
        System.out.println(StringToInt("1050a"));


        System.out.println(intToString(111231));
        System.out.println(StringToInt("11"));


        System.out.println(intToString(111231));
        System.out.println(StringToInt("11"));

        System.out.println(intToString(111231));
        System.out.println(StringToInt("11"));

        System.out.println(intToString(320855599));
        System.out.println(StringToInt("3453534534534534534534534534534"));


    }

    public static String intToString(int input) {

        try {
            return String.valueOf(input);
        } catch (Exception e) {
            System.out.println(input + " can not be converted to string");
            return null;
        }

    }


    public static int StringToInt(String input) {
        try {
            return Integer.parseInt(input);
        }catch (Exception e) {
            System.out.println(input + " can not be converted to int");
            return  0;
        }

    }
}