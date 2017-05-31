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

        BookingComAPI bookingComAPI = new BookingComAPI(rooms);
        System.out.println(Arrays.deepToString(bookingComAPI.findRooms(50, 2, "B", "B")));
        // Перевірка масиву кімнат(rooms)  на null
        // Перевірка ціни (price) на допустиме значення (>0)
        // Перевірка персон (persons) на допустиме значення (>0)


        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(rooms);
        System.out.println(Arrays.deepToString(tripAdvisorAPI.findRooms(50, 2, "B", "B")));
        // Перевірка масиву кімнат(rooms)  на null
        // Перевірка ціни (price) на допустиме значення (>0)
        // Перевірка персон (persons) на допустиме значення (>0)


        GoogleAPI googleAPI = new GoogleAPI(rooms);
        System.out.println(Arrays.deepToString(googleAPI.findRooms(50, 2, "B", "B")));
        // Перевірка масиву кімнат(rooms)  на null
        // Перевірка ціни (price) на допустиме значення (>0)
        // Перевірка персон (persons) на допустиме значення (>0)


        API[] apis = new API[3];
        Controller controller = new Controller(null);
        controller.requestRooms(50, 2, "B", "B");
        System.out.println(Arrays.deepToString(controller.requestRooms(50, 2, "B", "B")));
        // Завантаження null масиву (apis)
        // Завантаження null-елемента масиву (apis)
        // Перевірка коли prise і persons (<0)
        System.out.println(Arrays.deepToString(controller.check(googleAPI, bookingComAPI)));
        // Завантаження null - API api1
        // Завантаження null - API api2

    }
}