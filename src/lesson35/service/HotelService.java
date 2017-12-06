package lesson35.service;

import lesson35.DAO.HotelDAO;
import lesson35.model.Hotel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HotelService {
    public static Hotel addHotel(Hotel hotel) throws Exception {
        hotel.setId(generateID());
        BufferedReader brName = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter name of the hotel: ");
            hotel.setCountry(brName.readLine());
        } catch (IOException e) {
            System.err.println("Can not set value hotel");
        } catch (NullPointerException e) {
            System.err.println("hotel is null");
        }
        BufferedReader brCountry = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter country: ");
            hotel.setCountry(brCountry.readLine());
        } catch (IOException e) {
            System.err.println("Can not set value country");
        } catch (NullPointerException e) {
            System.err.println("hotel is null");
        }

        BufferedReader brCity = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter the cihty");
            hotel.setCity(brCity.readLine());
        } catch (IOException e) {
            System.err.println("Can not set value city");
        }

        BufferedReader brStreet = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter your country");
            hotel.setStreet(brStreet.readLine());
        } catch (IOException e) {
            System.err.println("Can not set value country");
        } finally {
            brCountry.close();
            brCity.close();
            brStreet.close();
        }

        return HotelDAO.addHotel(hotel);
    }

    public static ArrayList<Hotel> findHoteByName(String name) throws Exception {
        if (name == null) {
            throw new NullPointerException("name is null ");
        }
        ArrayList<Hotel> hotelsByName = new ArrayList<>();

        for (Hotel hotel : HotelDAO.readFromFile()) {
            if (hotel.getHotelName().equals(name))
                hotelsByName.add(hotel);
        }
        if (hotelsByName.size() == 0) {
            throw new Exception("hotel with this name was not found");
        }
        return hotelsByName;
    }


    public static ArrayList<Hotel> findHoteByCity(String city) throws Exception {
        if (city == null) {
            throw new NullPointerException("name is null ");
        }
        ArrayList<Hotel> hotels = new ArrayList<>();

        for (Hotel hotel : HotelDAO.readFromFile()) {
            if (hotel.getCity().equals(city))
                hotels.add(hotel);
        }
        if (hotels.size() == 0) {
            throw new Exception("City not found.");
        }
        return hotels;
    }


    private static long generateID() {
        return (long) (Math.random() * 2147483647);
    }
}
