package lesson11;

public class GoogleAPI implements API {
   private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }
    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {

        int counter = 0;
        int index = 0;
        for (Room room : rooms) {
            if (room.getPrice() >= price && room.getPersons() == persons && room.getCityName().equals(city) && room.getHotelName().equals(hotel)) {
                counter++;
            }
        }
        if (counter == 0) {
            return null;
        }

        Room[] okRooms = new Room[counter];

        for (Room room : rooms) {
            if (room.getPrice() >= price && room.getPersons() == persons && room.getCityName().equals(city) && room.getHotelName().equals(hotel)) {
                okRooms[index] = room;
                index++;
            }
        }
        return okRooms;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }


}