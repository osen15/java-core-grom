package lesson35.controller;

import lesson35.model.Filter;
import lesson35.model.Room;
import lesson35.service.RoomService;

import java.util.TreeSet;

public class RoomController {
    public Room addRoom(Room room) {
        return null;
    }

    public TreeSet<Room> findRooms(Filter filter) throws Exception {

        return RoomService.findRooms(filter);

    }

    public static void deleteRoom(Room room) throws  Exception {
        RoomService.deleteRoom(room);
    }


}
