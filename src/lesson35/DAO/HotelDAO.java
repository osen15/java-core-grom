package lesson35.DAO;

import lesson35.DAO.utils.ReWriteFile;
import lesson35.DAO.utils.ReadFromFile;
import lesson35.DAO.utils.ValidateFileDb;
import lesson35.DAO.utils.WriteToFile;
import lesson35.model.Hotel;

import java.util.ArrayList;

public class HotelDAO {
    private static int lineCounter = 1;
    private static final String HotelDB = "C://HotelDB.txt";

    public static Hotel addHotel(Hotel hotel) throws Exception {
        ValidateFileDb.validate(HotelDB);
        return WriteToFile.WriteToFile(hotel, HotelDB);
    }

    public static ArrayList<Hotel> getAll() throws Exception {
        ValidateFileDb.validate(HotelDB);
        ArrayList<Hotel> hotels = new ArrayList<>();
        for (String line : ReadFromFile.readFromFile(HotelDB)) {
            hotels.add(hotelMapper(line));
        }
        return hotels;


    }

    public static void deleteHotel(ArrayList<Hotel> hotels) throws Exception {
        ReWriteFile.reWriteFile(hotels, HotelDB);

    }


    public static Hotel hotelMapper(String line) throws Exception {
        String[] arrayHotel = line.split("\\, ");
        if (arrayHotel.length != 5) {
            throw new Exception("error in file: line " + lineCounter);

        }
        lineCounter++;
        return new Hotel(Long.parseLong(arrayHotel[0]), arrayHotel[1], arrayHotel[2], arrayHotel[3], arrayHotel[4]);
    }


}




