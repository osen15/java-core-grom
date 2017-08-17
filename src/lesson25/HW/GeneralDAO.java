package lesson25.HW;

public class GeneralDAO<T> {


    @SuppressWarnings("unchecked")
    private T[] array = (T[]) new Object[10];


    public T save(T t) throws Exception {
        if (array == null)
            throw new Exception("array is null");
        checkObject(t);

        int index = 0;
        for (T el : array) {
            if (el == null) {
                array[index] = t;
                return array[index];
            }

            index++;
        }
        throw new Exception("There are no places in the array");
    }





    public T[] getAll() throws Exception {
        if (array == null)
            throw new Exception("array is null");
        int count = 0;

        for (T t : array) {
            if (t != null)
                count++;
        }
        @SuppressWarnings("unchecked")

        T[] result =  (T[]) new Object[count];
        int index = 0;
        for (T t : array) {
            if (t != null) {
                result[index] = t;
                index++;
            }
        }

        return result;
    }


    private <T> void checkObject(T t) throws Exception{
        if (t == null) {
            throw new Exception("t can't be " + t);
        }





    }


}
