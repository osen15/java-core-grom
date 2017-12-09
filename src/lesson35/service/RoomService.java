package lesson35.service;

import lesson35.DAO.RoomDAO;
import lesson35.DAO.utils.ConvertListInStrBuff;
import lesson35.DAO.utils.WriteOldContentInToFile;
import lesson35.model.Room;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static lesson35.service.utils.IDGenerate.generateID;

public class RoomService {
    private static final String RoomDB = "C://RoomDB.txt";

    public Room addRoom(Room room) throws Exception {

        room.setId(generateID());
        BufferedReader brNumOfGuests = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter number of guests: ");
            room.setNumberOfGuests(Integer.parseInt(brNumOfGuests.readLine()));
        } catch (IOException e) {
            System.err.println("Can not set value");
        } catch (NullPointerException e) {
            System.err.println("Room is null");
        } catch (NumberFormatException e) {
            System.err.println("Wrong format");
        }
        BufferedReader brPrice = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter a price: ");
            room.setPrice(Double.parseDouble(brPrice.readLine()));
        } catch (IOException e) {
            System.err.println("Can not set value ");
        } catch (NullPointerException e) {
            System.err.println("Room is null");
        } catch (NumberFormatException e) {
            System.err.println("Wrong format");
        }
        BufferedReader brBrInc = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Breakfast included: enter (true) or (false)");
            room.setBreakfastIncluded(Boolean.parseBoolean(brBrInc.readLine()));
        } catch (IOException e) {
            System.err.println("Can not set value ");
        } catch (NullPointerException e) {
            System.err.println("Room is null");
        } catch (NumberFormatException e) {
            System.err.println("Wrong format");
        }
        BufferedReader brPets = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Pets allowed: enter (true) or (false)");
            room.setPetsAllowed(Boolean.parseBoolean(brBrInc.readLine()));
        } catch (IOException e) {
            System.err.println("Can not set value ");
        } catch (NullPointerException e) {
            System.err.println("Room is null");
        } catch (NumberFormatException e) {
            System.err.println("Wrong format");
        }
        BufferedReader brDateAvlbFrom = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter a date in format:    dd-MM-yyyy  example: 01-01-2018");
            room.setDateAvailableFrom(new SimpleDateFormat("dd-MM-yyyy").parse(brDateAvlbFrom.readLine()));
        } catch (IOException e) {
            System.err.println("Can not set value ");
        } catch (NullPointerException e) {
            System.err.println("Room is null");
        } catch (ParseException e) {
            System.err.println("Wrong format");
        }
        BufferedReader brIDHotel = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter a hotel ID");

            room.setHotel(HotelService.findHotelId(Long.parseLong(brIDHotel.readLine())));
        } catch (IOException e) {
            System.err.println("Can not set value ");
        } catch (NullPointerException e) {
            System.err.println("Room is null");
        } catch (NumberFormatException e) {
            System.err.println("Wrong format");
        }

        return RoomDAO.addRoom(room);
    }

    public static void deleteRoom(Room room) throws Exception {
        ArrayList<Room> rooms = new ArrayList<>();
        StringBuffer oldDatainBuff = ConvertListInStrBuff.listInStrBuff(RoomDAO.readFromFile());
             for (Room room1 : RoomDAO.readFromFile()) {
                 if (room1.getId() != room.getId())
                     rooms.add(room1);
             }


        try {
            RoomDAO.WriteNewContentInFile(rooms);

        } catch (IOException e) {
            WriteOldContentInToFile.writeOldContentToFile(oldDatainBuff, RoomDB);
            System.err.println("Can not delete hotel: " + room.getId());
        }

    }


}



