package lesson35.model;

public class Hotel {
    private long id;
    private String hotelName;
    private String country;
    private String city;
    private String street;

    public Hotel(long id) {
        this.id = id;
    }

    public Hotel(long id, String hotelName, String country, String city, String street) {
        this.id = id;
        this.hotelName = hotelName;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel hotel = (Hotel) o;

        if (id != hotel.id) return false;
        if (hotelName != null ? !hotelName.equals(hotel.hotelName) : hotel.hotelName != null) return false;
        if (country != null ? !country.equals(hotel.country) : hotel.country != null) return false;
        if (city != null ? !city.equals(hotel.city) : hotel.city != null) return false;
        return street != null ? street.equals(hotel.street) : hotel.street == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (hotelName != null ? hotelName.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return id + ", " + hotelName + ", " + country + ", " + city + ", " + street;
    }


}


