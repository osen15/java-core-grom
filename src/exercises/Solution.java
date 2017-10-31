package exercises;

import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws Exception {

        int[] first = {1, 2};
        int[] second = {1, 2};

        Solution solution = new Solution();


        //  System.out.println(solution.compareIntArrays(first, second));

        String[] first11 = {null, null};

        String[] second22 = {null, "B"};


        System.out.println(solution.compareStringArrays(first11, second22));


        Integer[] first111 = new Integer[]{1, 1, 1};


        Integer[] second222 = new Integer[]{1, 1, 1};
        System.out.println(solution.compareArrays(first11, second22));


    }

    private boolean compareIntArrays(int[] first, int[] second) throws Exception {
        if (first == null || second == null) {
            throw new Exception("array is null");
        }


        if (first.length != second.length) {
            throw new Exception("arrays are not the same");
        }

        int index = 0;
        for (int el : first) {
            if (el == second[index])
                index++;
            else return false;
        }
        return true;

    }


    private boolean compareStringArrays(String[] first, String[] second) throws Exception {
        if (first == null || second == null) {
            throw new Exception("array is null");
        }


        if (first.length != second.length) {
            throw new Exception("arrays are not the same");
        }

        int index = 0;
        for (String str : first) {
            if (str == null && second[index] == null)
                index++;
            else if (str != null && second[index] != null && str.equals(second[index]))
                index++;
            else return false;
        }
        return true;

    }


    private <T> boolean compareArrays(T[] first, T[] second) {

        if (first.length != second.length)
            return false;

        int index = 0;

        Comparator<T> tComparator = (o1, o2) -> {
            if (o1 == o2 || o1 != null && o2 != null && o1.toString().equals(o2.toString()))
                return 0;
            else return -1;
        };


        for (T t : first) {
            if (tComparator.compare(t, second[index]) == 0)
                index++;
            else return false;
        }
        return true;
    }


    private <T> boolean compareArrays2(T[] first, T[] second) {
        if (first.length != second.length)
            return false;

        int index = 0;

        for (T t : first) {
            if (t == second[index] || t != null && second[index] == null && t.toString().equals(second[index].toString()))
                index++;
            else return false;
        }

        return true;
    }


}




























