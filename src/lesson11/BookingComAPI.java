package lesson11;

public class BookingComAPI implements API {
    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int index = 0;
        Room[] rooms1 = new Room[sizeArray(price, persons, city, hotel)];
        for (Room room : rooms) {
            if (room.getPersons() == persons && room.getPrice() >= price - 100 && room.getPrice() <= price + 100 && room.getCityName() == city && room.getHotelName() == hotel)
                rooms1[index++] = room;
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
            if (room.getPersons() == persons && room.getPrice() >= price - 100 && room.getPrice() <= price + 100 && room.getCityName() == city && room.getHotelName() == hotel)
                count++;
        }
        return count;
    }
}
