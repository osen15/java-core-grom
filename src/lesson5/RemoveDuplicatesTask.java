package lesson5;


import java.util.Arrays;

public class RemoveDuplicatesTask {
    public static void main(String[] args) {
   int[] array = {1, 11, 12, 0, -2, 11, 0, -2, 35, 99, 9, 10, 1};
        System.out.println(Arrays.toString(removeDuplicates(array)));
    }

    public static int[] removeDuplicates(int[] array) {
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
}