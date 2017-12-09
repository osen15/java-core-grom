package lesson35.demo;

import lesson35.model.Room;
import lesson35.service.RoomService;

public class DemoRoom {
    public static void main(String[] args) throws Exception {
        Room room = new Room();
        RoomService roomService = new RoomService();
        roomService.addRoom(room);




    }

}
