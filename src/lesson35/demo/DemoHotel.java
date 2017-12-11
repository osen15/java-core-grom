package lesson35.demo;

import lesson35.DAO.HotelDAO;
import lesson35.model.Hotel;
import lesson35.service.HotelService;

public class DemoHotel {
    public static void main(String[] args) throws Exception {
        // Hotel hotel = new Hotel();
        HotelDAO hotelDAO = new HotelDAO();
        Hotel hotel1 = new Hotel(2031602864);
        HotelService hotelService = new HotelService();
        //  HotelService.addHotel(hotel);
        //  HotelService.deleteHotel(hotel1);
        //  System.out.println(HotelDAO.readFromFile());
      //  HotelService.deleteAllRoomsInHotel(new Hotel(162275106));

       HotelService.deleteHotel(new Hotel(1111111111));
    }


}
