package lesson14;


public class Test implements  Cloneable {
    private int someNumber;
    private String name;

    public Test(int someNumber, String name) {
        this.someNumber = someNumber;
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws  Exception {
        Test test = new Test(1000, "name");
        System.out.println(test);
        System.out.println(test.hashCode());


        Test test1 = (Test)(test.clone());
        System.out.println(test1);
        System.out.println(test1.hashCode());


       // Order test2 = new Order(test.getSomeNumber(), test.getName());



    }

    public int getSomeNumber() {
        return someNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Order{" +
                "someNumber=" + someNumber +
                ", name='" + name + '\'' +
                '}';
    }
}
