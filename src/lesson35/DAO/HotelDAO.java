package lesson35.DAO;

import lesson35.DAO.utils.ValidateFileDb;
import lesson35.model.Hotel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class HotelDAO{
    private static int lineCounter = 1;
    public static Hotel addHotel(Hotel hotel) throws Exception {
        ValidateFileDb.validate("HotelDB.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("HotelDB.txt", true))) {

            bw.append(hotel.toString());
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Can't write to file");
        }

        return hotel;
    }


    public static ArrayList<Hotel> readFromFile() throws Exception {
        ArrayList<Hotel> users = new ArrayList<>();
        Files.lines(Paths.get("HotelDB.txt"), StandardCharsets.UTF_8).forEach(line -> {
            try {
                users.add(hotelMapper(line));
            } catch (Exception e) {
                lineCounter = 1;
                e.printStackTrace();
            }
        });
        lineCounter = 1;
        return users;
    }



    public static Hotel hotelMapper(String line) throws  Exception {
        String[] arrayHotel = line.split("\\, ");
        if (arrayHotel.length != 5){
        throw new Exception("error in file: " + lineCounter );
        }
        lineCounter++;
        return new Hotel(Long.parseLong(arrayHotel[0]), arrayHotel[1], arrayHotel[2], arrayHotel[3], arrayHotel[4]);
    }
}