package lesson5;


import java.util.Arrays;

public class SortArrayAscendingAndDescendingHomeWork {
    public static void main(String[] args) {
        int[] array = {1, 0, 4, 6, -2};
        System.out.println(Arrays.toString(sortAscending(array)));
        System.out.println(Arrays.toString(sortDescending(array)));
    }

    public static int[]  sortAscending(int[] array) {
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
    public static int[]  sortDescending(int[] array) {
        boolean sort;
        do {
            sort = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i + 1]) {
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


















