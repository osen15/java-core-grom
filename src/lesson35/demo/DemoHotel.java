package lesson35.demo;

import lesson35.model.Hotel;
import lesson35.service.HotelService;

public class DemoHotel {
    public static void main(String[] args) throws  Exception {
       // Hotel hotel = new Hotel();
        Hotel hotel1 = new Hotel(162275106);
      //  HotelService hotelService = new HotelService();
      //  HotelService.addHotel(hotel);
        HotelService.deleteHotel(hotel1);

    }





}
