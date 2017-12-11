package lesson35.model;

import java.util.Date;

public class Filter {
    private int numberOfGuests;
    private double price;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private Date dateAvailableFrom;
    private String hotelName;
    private String country;
    private String city;

    public Filter() {
    }

    public Filter(int numberOfGuests, double price, boolean breakfastIncluded, boolean petsAllowed,
                  Date dateAvailableFrom, String hotelName, String country, String city) {
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.hotelName = hotelName;
        this.country = country;
        this.city = city;
    }

    public boolean checkParameters(Room room) {

        return (numberOfGuests != 0 || numberOfGuests == room.getNumberOfGuests())
                && (!(price != 0) || !(price != room.getPrice()))
                && breakfastIncluded == room.isBreakfastIncluded()
                && petsAllowed == room.isPetsAllowed()
                && (dateAvailableFrom == null || dateAvailableFrom.getTime() >= room.getDateAvailableFrom().getTime())
                && (hotelName == null || hotelName.equals(room.getHotel().getHotelName()))
                && (country == null || country.equals(room.getHotel().getCountry()))
                && (city == null || city.equals(room.getHotel().getCity()));
    }
}
