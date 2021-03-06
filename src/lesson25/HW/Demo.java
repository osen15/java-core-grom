package lesson25.HW;

public class Demo {

    public static void main(String[] args) throws Exception {
        String name = "Oleg";
        Integer value = new Integer(2);
        Long value1 = new Long(123);
        Short value2 = new Short((short) 1000);

        GeneralDAO<String> stringGeneralDAO = new GeneralDAO<>();            //String
        stringGeneralDAO.save(name);
        System.out.println(stringGeneralDAO.getAll());

        GeneralDAO<Integer> integerGeneralDAO = new GeneralDAO<>();          //Integer
        integerGeneralDAO.save(value);
        System.out.println(integerGeneralDAO.getAll());

        GeneralDAO<Long> longGeneralDAO = new GeneralDAO<>();                   //Long
        longGeneralDAO.save(value1);

        System.out.println(longGeneralDAO.getAll());


      //  Order order = new Order(2);                                    //Object from other directory
      //  GeneralDAO<Order> orderGeneralDAO = new GeneralDAO<>();
      //  orderGeneralDAO.Save(order);
      //  System.out.println(Arrays.toString(orderGeneralDAO.getAll()));

        GeneralDAO<Short> shortGeneralDAO = new GeneralDAO<>();
        shortGeneralDAO.save(value2);
        System.out.println(shortGeneralDAO.getAll());

    }
}