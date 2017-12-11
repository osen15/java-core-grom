package lesson35.DAO;

import lesson35.DAO.utils.ReWriteFile;
import lesson35.DAO.utils.ValidateFileDb;
import lesson35.DAO.utils.WriteToFile;
import lesson35.model.Hotel;

import java.io.*;
import java.util.ArrayList;

public class HotelDAO {
    private static int lineCounter = 1;
    private static final String HotelDB = "C://HotelDB.txt";

    public static Hotel addHotel(Hotel hotel) throws Exception {
        ValidateFileDb.validate(HotelDB);
        return WriteToFile.WriteToFile(hotel, HotelDB);
    }

    public static ArrayList<Hotel> readFromFile() throws Exception {

        ArrayList<Hotel> hotels = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(HotelDB))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (!line.isEmpty())
                    hotels.add(hotelMapper(line));
            }

        } catch (FileNotFoundException e) {

            System.err.println("File not exist");
        } catch (IOException e) {

            System.err.println("Reading from fileDB " + HotelDB + " failed");

        }

        return hotels;


    }

    public static void WriteNewContentInFile(ArrayList<Hotel> hotels) throws Exception {
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