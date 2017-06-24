package lesson15.HWAPI;


public class Controller {
    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {


        int indexOfRoom = 0;

        for (API api : apis) {
            if (api.findRooms(price, persons, city, hotel) != null) {
                indexOfRoom += api.findRooms(price, persons, city, hotel).length;
            }
        }

        if (indexOfRoom == 0) {
            return null;
        }

        Room[] result = new Room[indexOfRoom];

        int index = 0;
        for (API api : apis) {
            if (api.findRooms(price, persons, city, hotel) != null) {
                for (Room room : api.findRooms(price, persons, city, hotel)) {
                    result[index] = room;
                    index++;
                }
            }
        }
        return result;
    }


    public Room[] check(API api1, API api2) {


        int roomCount = 0;

        for (Room room1 : api1.getAll()) {
            if (room1 == null) continue;

            for (Room room2 : api2.getAll()) {
                if (room2 == null) continue;

                if (room1.equals(room2)) roomCount++;
            }
        }


        Room[] rooms = new Room[roomCount];
        int lastRoomPosition = 0;

        for (Room room1 : api1.getAll()) {
            if (room1 == null) continue;

            for (Room room2 : api2.getAll()) {
                if (room2 == null) continue;

                if (room1.equals(room2))
                    rooms[lastRoomPosition++] = room1;
            }
        }

        return rooms;
    }

}