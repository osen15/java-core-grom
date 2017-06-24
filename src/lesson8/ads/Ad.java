package lesson8.ads;


import java.util.Date;

public class Ad extends BaseEntity{

    int price;
    Date dateCreated;

    public Ad(long id, int price) {
        super(id);
        this.price = price;
        this.dateCreated = new Date();
    }
    void  publishAd() {
        // some logic
    }
}
