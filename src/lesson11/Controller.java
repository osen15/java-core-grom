package lesson11;


public class Controller {
    API[] apis;

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




        int counter = 0;

        for (Room room : api1.getAll()) {
            for (Room room2 : api2.getAll()) {
                if (room.equals(room2) && room.hashCode() == room2.hashCode()) {
                    counter++;
                }
            }
        }
        if (counter == 0) {
            return null;
        }

        Room[] checkRoom = new Room[counter];

        int indexCheck = 0;

        for (Room room : api1.getAll()) {
            for (Room room2 : api2.getAll()) {
                if (room.equals(room2) && room.hashCode() == room2.hashCode()) {
                    checkRoom[indexCheck] = room;
                    indexCheck++;
                }
            }
        }
        return checkRoom;
    }

}