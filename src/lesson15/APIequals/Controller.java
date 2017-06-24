package lesson15.APIequals;


import lesson11.API;
import lesson11.Room;

public class Controller {
    lesson11.API[] apis;

    public Controller(lesson11.API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {


        int indexOfRoom = 0;

        for (lesson11.API api : apis) {
            if (api.findRooms(price, persons, city, hotel) != null) {
                indexOfRoom += api.findRooms(price, persons, city, hotel).length;
            }
        }

        if (indexOfRoom == 0) {
            return null;
        }

        Room[] result = new Room[indexOfRoom];

        int index = 0;
        for (lesson11.API api : apis) {
            if (api.findRooms(price, persons, city, hotel) != null) {
                for (Room room : api.findRooms(price, persons, city, hotel)) {
                    result[index] = room;
                    index++;
                }
            }
        }
        return result;
    }


    public Room[] check(lesson11.API api1, API api2) {


        Room[] first = api1.getAll();
        Room[] second = api2.getAll();

        int duplicates = 0;

        for (Room room : first) {
            for (Room room2 : second) {
                if (room.equals(room2) && room.hashCode() == room2.hashCode()) {
                    duplicates++;
                }
            }
        }
        if (duplicates == 0) {
            return null;
        }

        Room[] checkRoom = new Room[duplicates];

        int indexCheck = 0;

        for (Room room : first) {
            for (Room room2 : second) {
                if (room.equals(room2) && room.hashCode() == room2.hashCode()) {
                    checkRoom[indexCheck] = room;
                    indexCheck++;
                }
            }
        }
        return checkRoom;
    }

}