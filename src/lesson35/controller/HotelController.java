package lesson35.controller;

import lesson35.model.Hotel;
import lesson35.service.HotelService;

import java.util.ArrayList;

public class HotelController {

    public Hotel addHotel(Hotel hotel) throws Exception {
        return HotelService.addHotel(hotel);
    }

    public ArrayList<Hotel> findHoteByName(String name) throws Exception {
        return HotelService.findHoteByName(name);
    }

    public ArrayList<Hotel> findHotelByCity(String city) throws Exception {
        return HotelService.findHoteByCity(city);
    }

    public Hotel deleteHotel(Hotel hotel){
        return null;
    }


}
