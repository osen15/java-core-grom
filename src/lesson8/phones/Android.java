package lesson8.phones;


public class Android extends Phone {


    String androidVersion;
    int screenSize;

    String secretDeviseCode;

    public Android(int price, double weight, String countryProdused, String androidVersion, int screenSize, String secretDeviseCode) {
        // this.price = price;
        // this.weight = weight;
        // this.countryProdused = countryProdused;

        // this - reference to the current class object
        // super - reference to the parent class object


        super(price, weight, countryProdused);
        this.androidVersion = androidVersion;
        this.screenSize = screenSize;
        this.secretDeviseCode = secretDeviseCode;
    }


    void installNewAndroidVersion() {
        //some logic
        System.out.println(" installNewAndroidVersion invoked...");
    }
}

