package lesson4;

/**
 * Created by Masja on 26.03.2017.
 */
public class StringConcatMethodPractice {
    public static void main(String[] args) {
        System.out.println(concat("Oleg ","Seniukh ","Java"));

    }
    public static String concat(String word1, String word2, String word3){
        String wordConcat = word1 + word2 + word3;
        return wordConcat;

    }
}
