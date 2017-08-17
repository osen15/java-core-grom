package lesson25;

public class Demo {
    public static void main(String[] args) throws Exception {
        GeneralDAO generalDAO = new GeneralDAO();

        Order order = new Order(1);


        generalDAO.validate(order);


        TestClass<String, Order, Long> testClass = new TestClass<>();
        System.out.println(testClass.doSomething1("rrr"));


        //long - Long
        //int - Integer
        //short - Short

        int test = 100;

        long variable1 = 111;

        Long variable2 = new Long(222);   // клас обгортка


        generalDAO.validate(variable2);   // об єкт класу обгортки

        generalDAO.validate(variable1);  // теж працює автоприведення типів

        generalDAO.validate(test);


    }


}
