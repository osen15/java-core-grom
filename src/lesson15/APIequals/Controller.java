package lesson15.APIequals;


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

