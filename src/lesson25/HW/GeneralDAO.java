package lesson25.HW;
    public class GeneralDAO<T> {


        @SuppressWarnings("unchecked")
        private T[] array = (T[]) new Object[10];


        public T save(T t) throws Exception {
            if (array == null) {
                throw new Exception("array is null");
            }
            if (t == null) {
                throw new Exception("t can't be " + t);
            }
            if (sameObject(t)) {
                throw new Exception(t + " Such an object already exists in the array");
            }
            if (t instanceof String && ((String) t).length() > 10) {
                throw new Exception(t + " Length must be up to 10 characters");
            }
            if (t.equals(0)){
                throw new Exception(t + " can't be");
            }



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

            T[] result = (T[]) new Object[count];
            int index = 0;
            for (T t : array) {
                if (t != null) {
                    result[index] = t;
                    index++;
                }
            }

            return result;
        }


        private boolean sameObject(T t) throws Exception {
            for (T t1 : array) {
                if (t1 != null && t1.equals(t)) {
                    return true;
                }
            }
            return false;
        }
    }


