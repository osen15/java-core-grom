package lesson15.APIequals;


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


        // Перевірка масиву кімнат(rooms)  на null
        BookingComAPI bookingComAPI = new BookingComAPI(null);
        System.out.println(Arrays.deepToString(bookingComAPI.findRooms(50, 2, "B", "B")));
        // Перевірка ціни (price) на допустиме значення (>0)
       // System.out.println(Arrays.deepToString(bookingComAPI.findRooms(50, 2, "B", "B")));
        // Перевірка персон (persons) на допустиме значення (>0)
      //  System.out.println(Arrays.deepToString(bookingComAPI.findRooms(-50, -2, "B", "B")));


        // Перевірка масиву кімнат(rooms)  на null
        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(null);
      //  System.out.println(Arrays.deepToString(tripAdvisorAPI.findRooms(50, 2, "B", "B")));
        // Перевірка ціни (price) на допустиме значення (>0)
       // System.out.println(Arrays.deepToString(tripAdvisorAPI.findRooms(-50, 2, "B", "B")));
        // Перевірка персон (persons) на допустиме значення (>0)
       // System.out.println(Arrays.deepToString(tripAdvisorAPI.findRooms(-50, -2, "B", "B")));


        // Перевірка масиву кімнат(rooms)  на null
        GoogleAPI googleAPI = new GoogleAPI(null);
      //  System.out.println(Arrays.deepToString(googleAPI.findRooms(50, 2, "B", "B")));
        // Перевірка ціни (price) на допустиме значення (>0)
      //  System.out.println(Arrays.deepToString(googleAPI.findRooms(-50, 2, "B", "B")));
        // Перевірка персон (persons) на допустиме значення (>0)
      //  System.out.println(Arrays.deepToString(googleAPI.findRooms(-50, -2, "B", "B")));


        API[] apis = new API[3];
        Controller controller = new Controller(null);
        controller.requestRooms(50, 2, "B", "B");
        // Завантаження null масиву (apis)
       // System.out.println(Arrays.deepToString(controller.requestRooms(50, 2, "B", "B")));
        // Завантаження null-елемента масиву (apis)
       // System.out.println(Arrays.deepToString(controller.requestRooms(50, 2, "B", "B")));
        // Перевірка коли prise і persons (<0)
       // System.out.println(Arrays.deepToString(controller.requestRooms(-50, -2, "B", "B")));


        // Завантаження null - API api1
       // System.out.println(Arrays.deepToString(controller.check(null, bookingComAPI)));
        // Завантаження null - API api2
       // System.out.println(Arrays.deepToString(controller.check(googleAPI, null)));
        // Завантаження null - API api1 і API api2
       // System.out.println(Arrays.deepToString(controller.check(null, null)));
    }

}