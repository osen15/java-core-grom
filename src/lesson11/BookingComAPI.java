package lesson11;

public class BookingComAPI implements API {
    Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {


        int numberOfRoom = 0;
        int index = 0;
        int min = price - 100;
        int max = price + 100;

        for (Room room : rooms) {
            if (room.getPrice() >= min && room.getPrice() <= max && room.getPersons() == persons && room.getCityName().equals(city) && room.getHotelName().equals(hotel)) {
                numberOfRoom++;
            }
        }
        if (numberOfRoom == 0) {
            return null;
        }

        Room[] FinedRoom = new Room[numberOfRoom];

        for (Room room : rooms) {
            if (room.getPrice() >= min && room.getPrice() <= max && room.getPersons() == persons && room.getCityName().equals(city) && room.getHotelName().equals(hotel)) {
                FinedRoom[index] = room;
                index++;
            }

        }

        return FinedRoom;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}

