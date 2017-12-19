package lesson35.service;

import lesson35.DAO.HotelDAO;
import lesson35.DAO.RoomDAO;
import lesson35.DAO.utils.ConvertListInStrBuff;
import lesson35.DAO.utils.WriteOldContentInToFile;
import lesson35.model.Hotel;
import lesson35.model.Room;

import java.io.IOException;
import java.util.ArrayList;

public class HotelService {
    private static final String HotelDB = "C://HotelDB.txt";
    private static final String RoomDB = "C://RoomDB.txt";

    public static Hotel addHotel(Hotel hotel) throws Exception {
        if (hotel == null) {
            throw new Exception("hotel is null");
        }
        if (checkHotel(hotel.getId())) {
            throw new Exception("hotel " + hotel.getId() + "already exists");
        }
        return HotelDAO.addHotel(hotel);

    }

    public static ArrayList<Hotel> findHoteByName(String name) throws Exception {
        if (name == null) {
            throw new NullPointerException("name is null ");
        }
        ArrayList<Hotel> hotelsByName = new ArrayList<>();

        for (Hotel hotel : HotelDAO.getAll()) {
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

        for (Hotel hotel : HotelDAO.getAll()) {
            if (hotel.getCity().equals(city))
                hotels.add(hotel);
        }
        if (hotels.size() == 0) {
            throw new Exception("City not found.");
        }
        return hotels;
    }

    public static void deleteHotel(Hotel hotel) throws Exception {
        deleteAllRoomsInHotel(hotel);
        ArrayList<Hotel> hotels = new ArrayList<>();
        StringBuffer oldDatainBuff = ConvertListInStrBuff.listInStrBuff(HotelDAO.getAll());
        for (Hotel hotel1 : HotelDAO.getAll()) {
            if (hotel1.getId() != hotel.getId())
                hotels.add(hotel1);
        }
        if (HotelDAO.getAll().size() == hotels.size())
            throw new Exception("hotel with this" + hotel.getId() + " not found");

        try {
            HotelDAO.deleteHotel(hotels);

        } catch (IOException e) {
            WriteOldContentInToFile.writeOldContentToFile(oldDatainBuff, HotelDB);
            System.err.println("Can not delete hotel: " + hotel.getId());
        }

    }

    public static void deleteAllRoomsInHotel(Hotel hotel) throws Exception {
        ArrayList<Room> rooms = new ArrayList<>();
        StringBuffer oldDatainBuff = ConvertListInStrBuff.listInStrBuff(RoomDAO.getAll());
        for (Room room1 : RoomDAO.getAll()) {
            if (room1.getHotel().getId() != hotel.getId())
                rooms.add(room1);
        }
        if (RoomDAO.getAll().size() == rooms.size()) {
            throw new Exception("hotel with this " + hotel.getId() + " not found");
        }


        try {
            RoomDAO.deleteRoom(rooms);

        } catch (IOException e) {
            WriteOldContentInToFile.writeOldContentToFile(oldDatainBuff, RoomDB);
            System.err.println("Can not delete rooms from hotel: " + hotel.getId());
        }


    }

    public static Hotel findHotelByID(long id) throws Exception {
        for (Hotel hotel : HotelDAO.getAll()) {
            if (hotel.getId() == id) {
                return hotel;
            }
        }

        throw new Exception("Hotel with this " + id + " not found");
    }

    public static boolean checkHotel(long id) throws Exception {
        for (Hotel hotel : HotelDAO.getAll()) {
            if (hotel.getId() == id) {
                return true;
            }
        }
        return false;

    }

}




