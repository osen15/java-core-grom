package lesson17;


import java.util.Arrays;

public class MostCountW {
    public static void main(String[] args) {
        String test = "               s     s         ";
        System.out.println((mostCountedWord(test)));

    }

    private static String mostCountedWord(String input) {
        if (input == null && input.length() ==0)  // перевірка на null
            return null;
        String[] words = input.split(" "); // масив елементів стрінга

        int[] res = new int[words.length]; // масив повторень одинакових слів
        int index = 0;  // індекс елемента масиву res[]
        for (String word : words) {
            int count = 0;  // лічильник повторів
            for (String item : words) {
                if (word.equals(item) && checkWord(item) && !item.equals(""))  // логіка на те щоб рахував лічильник
                    count++; // лічильник додає кожного true +1
            }
            res[index] = count; // записує в кожний елемент масиву res скыльки разів повторився елемент з масиву words
            index++; // перекидає на слідуючий елемент
        }

        int pos = getHighestElement(res);  // присвоєння макс числа
        if(pos == -1 || !checkWord(words[pos])) // логіка на null
            return null;
        return words[pos]; // вертаємо слово
    }
    private static boolean checkWord(String word) {   // перевірка символів на букву
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            if (!Character.isLetter(ch))
                return false;
        }
        return true;
    }

    private static int getHighestElement(int[] array) {  // метод який шукає найбільше число в масиві.
        int[] oldArray = Arrays.copyOf(array, array.length);
        array = sortArray(array);
        int index = 0;
        for (int el : oldArray) {
            if (el == array[0] && array[0] != 0)
                return index;
            index++;
        }
        return -1;
    }

    private static int[] sortArray(int[] array) { //метод сортування масиву в порядку спадання
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int k = i + 1; k < array.length; k++) {
                if (array[i] < array[k]) {
                    temp = array[i];
                    array[i] = array[k];
                    array[k] = temp;
                }
            }
        }
        return array;
    }
}
