package lesson35.demo;

import lesson35.DAO.HotelDAO;
import lesson35.controller.HotelController;
import lesson35.model.Hotel;

public class DemoHotel {
    public static void main(String[] args) throws Exception {
        // Hotel hotel = new Hotel();
        HotelDAO hotelDAO = new HotelDAO();
       // Hotel hotel1 = new Hotel(2031602864);
       // HotelService hotelService = new HotelService();
        Hotel hotel = new Hotel(1, "Leopold", "U", "D", "F");

        HotelController hotelController = new HotelController();
        hotelController.addHotel(hotel);

    }


}
