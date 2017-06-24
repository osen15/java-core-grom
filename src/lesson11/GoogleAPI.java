package lesson11;

public class GoogleAPI implements API {
    Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {

        int numberOfRoom = 0;
        int index = 0;
        for (Room room : rooms) {
            if (room.getPrice() >= price && room.getPersons() == persons && room.getCityName().equals(city) && room.getHotelName().equals(hotel)) {
                numberOfRoom++;
            }
        }
        if (numberOfRoom == 0) {
            return null;
        }

        Room[] FindedRoom = new Room[numberOfRoom];

        for (Room room : rooms) {
            if (room.getPrice() >= price && room.getPersons() == persons && room.getCityName().equals(city) && room.getHotelName().equals(hotel)) {
                FindedRoom[index] = room;
                index++;
            }
        }
        return FindedRoom;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}