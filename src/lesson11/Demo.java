package lesson11;


import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {


        Room room1 = new Room(1l, 0, 1, new Date(), "B", "B");
        Room room2 = new Room(2l, 50, 2, new Date(), "B", "B");
        Room room3 = new Room(3l, 150, 3, new Date(), "B", "B");
        Room room4 = new Room(4l, 50, 2, new Date(), "B", "B");
        Room room5 = new Room(5l, 350, 3, new Date(), "E", "E");
        Room[] rooms = {room1, room2, room3, room4, room5};
        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(rooms);
        GoogleAPI googleAPI = new GoogleAPI(rooms);
        System.out.println(Arrays.toString(googleAPI.findRooms(50,2,"B","B")));



        BookingComAPI bookingComAPI = new BookingComAPI(rooms);
        TripAdvisorAPI tripAdvisorAPI1 = new TripAdvisorAPI(rooms);
        GoogleAPI googleAPI1 = new GoogleAPI(rooms);
        API[] apis =new API[3];
        Controller controller = new Controller(apis);
        System.out.println(Arrays.toString(controller.requestRooms(50,2, "B", "B")));











    }
}