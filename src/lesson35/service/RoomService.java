package lesson35.service;

import lesson35.DAO.RoomDAO;
import lesson35.DAO.utils.ConvertListInStrBuff;
import lesson35.DAO.utils.WriteOldContentInToFile;
import lesson35.model.Filter;
import lesson35.model.Room;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

public class RoomService {
    private static final String RoomDB = "C://RoomDB.txt";

    public Room addRoom(Room room) throws Exception {

        if (checkRoom(room.getId())){
            throw  new Exception("This room :" + room.getId() + " is already exists");
        }

        return RoomDAO.addRoom(room);
    }


    public static void deleteRoom(Room room) throws Exception {
        ArrayList<Room> rooms = new ArrayList<>();
        StringBuffer oldDatainBuff = ConvertListInStrBuff.listInStrBuff(RoomDAO.getAll());
        for (Room room1 : RoomDAO.getAll()) {
            if (room1.getId() != room.getId())
                rooms.add(room1);
        }
        if (RoomDAO.getAll().size() == rooms.size()) {
            throw new Exception("room with this " + room.getId() + " not found");
        }

        try {
            RoomDAO.deleteRoom(rooms);

        } catch (IOException e) {
            WriteOldContentInToFile.writeOldContentToFile(oldDatainBuff, RoomDB);
            System.err.println("Can not delete hotel: " + room.getId());
        }

    }

    public static TreeSet<Room> findRooms(Filter filter) throws Exception {
        TreeSet<Room> filteredRooms = new TreeSet<>();
        for (Room room : RoomDAO.getAll())
            if (filter.checkParameters(room))
                filteredRooms.add(room);
        return filteredRooms;
    }

    public static Room findRoomByID(long id) throws Exception {
        for (Room room : RoomDAO.getAll()) {
            if (room.getId() == id) {
                return room;
            }
        }

        throw new Exception("Room with this " + id + " not found");
    }

    public static boolean checkRoom(long id) throws Exception {
        for (Room room : RoomDAO.getAll()) {
            if (room.getId() == id) {
                return true;
            }
        }

        return false;
    }

}



