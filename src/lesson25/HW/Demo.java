package lesson25.HW;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) throws Exception {
        String name = "Oleg";
        Integer value = new Integer(100);
        Long value1 = new Long(123);

        GeneralDAO<String> stringGeneralDAO = new GeneralDAO<>();
        stringGeneralDAO.save(name);
        System.out.println(Arrays.toString(stringGeneralDAO.getAll()));

        GeneralDAO<Integer> integerGeneralDAO = new GeneralDAO<>();
        integerGeneralDAO.save(value);
        System.out.println(Arrays.toString(integerGeneralDAO.getAll()));

        GeneralDAO<Long> longGeneralDAO = new GeneralDAO<>();
        longGeneralDAO.save(value1);
        System.out.println(Arrays.toString(longGeneralDAO.getAll()));

    }
}
