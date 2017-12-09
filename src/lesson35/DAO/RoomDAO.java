package lesson35.DAO;

import lesson35.DAO.utils.ReWriteFile;
import lesson35.DAO.utils.ValidateFileDb;
import lesson35.DAO.utils.WriteToFile;
import lesson35.model.Hotel;
import lesson35.model.Room;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class RoomDAO {

    private static int lineCounter = 1;
    private static final String RoomDB = "C://RoomDB.txt";

    public static Room addRoom(Room room) throws Exception {
        ValidateFileDb.validate(RoomDB);
        return WriteToFile.WriteToFile(room, RoomDB);
    }

    public static ArrayList<Room> readFromFile() throws Exception {
        ArrayList<Room> rooms = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader(RoomDB))) {
            String line;

            while ((line = br.readLine()) != null) {
                rooms.add(roomMapper(line));

            }

        } catch (FileNotFoundException e) {
            lineCounter = 0;
            System.err.println("File not exist");
        } catch (IOException e) {
            lineCounter = 0;
            System.err.println("Reading from fileDB " + RoomDB + " failed");

        }
        lineCounter = 0;
        return rooms;

    }
    public static void WriteNewContentInFile(ArrayList<Room> rooms) throws Exception {
        ReWriteFile.reWriteFile(rooms, RoomDB);
    }

    public static Room roomMapper(String line) throws Exception {
        String[] arrayRoom = line.split("\\, ");
        if (arrayRoom.length != 7) {
            throw new Exception("error in file: " + lineCounter);
        }
        lineCounter++;
        return new Room(Long.parseLong(arrayRoom[0]), Integer.parseInt(arrayRoom[1]),
                Double.parseDouble(arrayRoom[2]), Boolean.parseBoolean(arrayRoom[3]),
                Boolean.parseBoolean(arrayRoom[4]), new SimpleDateFormat("dd-MM-yyyy").parse(arrayRoom[5]),
                new Hotel(Long.parseLong(arrayRoom[6])));
    }


}