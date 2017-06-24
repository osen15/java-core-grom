package lesson5;

import java.util.Arrays;

/**
 * Created by Masja on 01.04.2017.
 */
public class FirstTimeInMarathon {
    public static void main(String[] args) {
        String[] names = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"};
        int[] times = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};
        System.out.println(Arrays.toString(findNamesByTime(names, times, firstTime(times))) + " " + firstTime(times));


    }

    static int firstTime(int[] array) {
        int min = array[0];
        for (int el : array) {
            if (el < min) {
                min = el;
            }
        }
        return min;
    }

    static String[] findNamesByTime(String[] sportsman, int[] times, int n) {
        int count = 0;
        for (int time : times) {
            if (time == n) {
                count++;
            }
        }
        String[] results = new String[count];
        int index = 0;
        int resultsInd = 0;
        for (int time : times) {
            if (time == n) {
                results[resultsInd] = sportsman[index];
                resultsInd++;
            }
            index++;
        }
        return results;
    }
}



