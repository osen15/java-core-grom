package lesson11;

public class GoogleAPI implements API {
    Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }


    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        Room[] rooms1 = new Room[sizeArray(price, persons, city, hotel)];
        int index = 0;
        for (Room room : rooms) {
            if (room.getPersons() == persons && room.getPrice() == price && room.getCityName() == city && room.getHotelName() == hotel) {
                rooms1[index++] = room;
            }

        }
        return rooms1;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }


    private int sizeArray(int price, int persons, String city, String hotel) {
        int count = 0;

        for (Room room : rooms) {
            if (room.getPersons() == persons && room.getPrice() == price && room.getCityName() == city && room.getHotelName() == hotel)
                count++;
        }
        return count;
    }

}