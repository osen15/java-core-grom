package exercises;

public class Solution {
    public static void main(String[] args) throws Exception {

        int[] first = {1, 2};
        int[] second = {1, 2};

        Solution solution = new Solution();

        System.out.println(solution.compareIntArrays(first, second));

        String[] first11 = {null, null};

        String[] second22 = {null, "KK"};

        System.out.println(solution.compareStringArrays(first11, second22));


        Integer[] first111 = new Integer[]{null, 2, null};
        Integer[] second222 = new Integer[]{null, 2, null};
        System.out.println(solution.compareArrays(first111, second222));

    }

    private boolean compareIntArrays(int[] first, int[] second) throws Exception {
        if (first == null || second == null) {
            throw new Exception("array is null");
        }

        if (first.length == 0 && second.length == 0) {
            return true;
        }
        if (first.length != second.length) {
            throw new Exception("arrays are not the same");
        }


        for (int i = 0; i < first.length; ) {
            if (first[i] == second[i])
                i++;
            else return false;
        }
        return true;

    }


    private boolean compareStringArrays(String[] first, String[] second) throws Exception {
        if (first == null || second == null) {
            throw new Exception("array is null");
        }

        if (first.length == 0 && second.length == 0) {
            return true;
        }
        if (first.length != second.length) {
            throw new Exception("arrays are not the same");
        }


        for (int i = 0; i < first.length; ) {
            if (first[i] != null && second[i] != null && first[i].equals(second[i])) {
                i++;
            } else if (first[i] == null && second[i] == null) {
                i++;
            } else return false;
        }
        return true;

    }

    private <T> boolean compareArrays(T[] first, T[] second) throws Exception {


        if (first == null || second == null) {
            throw new Exception("array is null");
        }

        if (first.length == 0 && second.length == 0) {
            return true;
        }
        if (first.length != second.length) {
            throw new Exception("lenght isn't the same");
        }

int index = 0;
for (T t : first){

}










        for (int i = 0; i < first.length; ) {
            if (first[i] != null && second[i] != null && first[i].equals(second[i])) {
                i++;
            } else if (first[i] == null && second[i] == null)
                i++;
            else return false;

        }
        return true;


    }


    //   private Integer[] arrIntToArrInteger(int[] array) {
    //       Integer[] newArray = new Integer[array.length];
    //   int i = 0;
    //       for (int value : array) {
    //        newArray[i++] = value;
    //    }
    //    return newArray;
    //  }
}





























