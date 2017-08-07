package lesson21;

public class Company {

    private int numberOfEmployees;
    private String name;
    private static String licence;
    private static int maxNumbersOfEmployees = 100;

   static  {
       System.out.println("Code block is called");
       init();


    }

    public Company(int numberOfEmployees, String name) throws Exception {
        if (numberOfEmployees > maxNumbersOfEmployees)
            throw new Exception("Company can have " + maxNumbersOfEmployees + " employees");
        this.numberOfEmployees = numberOfEmployees;
        this.name = name;

    }

    public static void validate() throws Exception {
        if (!licence.equals("TTT111"))
            throw new Exception("Wrong licence " + licence);


    }

    private static void init() {
        maxNumbersOfEmployees = 100;
    }


    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public String getName() {
        return name;
    }

    public String getLicence() {
        return licence;
    }

    public static void setLicence(String licence) {
        Company.licence = licence;
    }

    private  static  class Test{

    }


}
