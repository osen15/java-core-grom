package lesson35.DAO;

import lesson35.DAO.utils.ValidateFileDb;
import lesson35.model.Hotel;
import lesson35.model.Room;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RoomDAO {

    private static int lineCounter = 1;

    public static Room addRoom(Room room) throws Exception {
        ValidateFileDb.validate("RoomDB.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("RoomDB.txt", true))) {

            bw.append(room.toString());
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Can't write to fileDB");
        }

        return room;
    }


    public static Room roomMapper(String line) throws Exception {
        String[] arrayRoom = line.split("\\, ");
        if (arrayRoom.length != 7) {
            throw new Exception("error in file: " + lineCounter);
        }
        lineCounter++;
        return new Room(Long.parseLong(arrayRoom[0]), Integer.parseInt(arrayRoom[1]),
                Double.parseDouble(arrayRoom[2]), Boolean.parseBoolean(arrayRoom[3]),
                Boolean.parseBoolean(arrayRoom[4]), parseStringToDate(arrayRoom[5]),
                new Hotel(Long.parseLong(arrayRoom[6])));
    }

    private static Date parseStringToDate(String string) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd--MMM--yyyy", Locale.ENGLISH);
        Date birthDate = new Date();
        try {
            birthDate = simpleDateFormat.parse(string);
        } catch (ParseException e) {
            System.err.println("wrong date format");
        }

        return birthDate;
    }
}