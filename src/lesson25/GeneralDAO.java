package lesson25;


public class GeneralDAO {


    private void print(String order) {

        System.out.println("order is:" + order);

    }


    public <T> void validate1(T t) throws Exception {


        if (t.equals(0))
            throw new Exception("id can't be negative");


    }


    public <K> void validate2(K k) {
        if (k.equals(100)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }


}

