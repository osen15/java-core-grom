package lesson8.phones;


public class Phone {
    int price;
    double weight;
    String countryProdused;

    public Phone(int price, double weight, String countryProdused) {
        System.out.println("Phone constructor was invoked...");
        this.price = price;
        this.weight = weight;
        this.countryProdused = countryProdused;
    }
   void orderPhone(){
        // some logic
       System.out.println("order phone invoked...");

    }
}
