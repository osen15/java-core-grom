package lesson5;

import java.util.Arrays;


public class UniqueCountHomeWork {

    public static void main(String[] args) {
        int[] array = {5, 1, 1, 1, 2, 2, 2, 2, 3, 4,};;
        System.out.println(Arrays.toString(resultArray(array)));
        System.out.println(Arrays.toString(sortArray(resultArray(array))));
        System.out.println(uniqueCount(array));
    }

    static int [] resultArray(int[] array) {
        boolean sort[] = new boolean[array.length];
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (!sort[i]) {
                int a = array[i];

                for (int j = i + 1; j < array.length; j++) {
                    if (a == array[j]) {
                        sort[j] = true;
                        count++;
                    }
                }
            }
        }


        int[] result = new int[array.length - count];

        for (int i = 0, j = 0; i < array.length; i++) {
            if (!sort[i]){
                result[j++] = array[i];
            }


        }
        return result;
    }
    static int [] sortArray(int[] array){
        boolean sort;
        do {
            sort = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int a = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = a;
                    sort = true;
                }
            }

        }
        while (sort);
        return array;
    }
    static  int  uniqueCount(int[] array){
        return sortArray(resultArray(array)).length;
    }
}

