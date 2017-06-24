package lesson15.APIequals;


public class TripAdvisorAPI implements API {
    Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {

        int numberOfRoom = 0;
        int index = 0;
        int roomPriceMin = price - 10;
        int roomPriceMax = price + 10;
        int roomPersonsMin = persons - 1;
        int roomPersonsMax = persons + 1;


        for (Room room : rooms) {
            if (room.getPrice() >= roomPriceMin && room.getPrice() <= roomPriceMax && room.getPersons() >= roomPersonsMin && room.getPersons() <= roomPersonsMax && room.getCityName().equals(city) && room.getHotelName().equals(hotel)) {
                numberOfRoom++;
            }
        }
        if (numberOfRoom == 0) {
            return null;
        }

        Room[] FindedRoom = new Room[numberOfRoom];

        for (Room room : rooms) {
            if (room.getPrice() >= roomPriceMin && room.getPrice() <= roomPriceMax && room.getPersons() >= roomPersonsMin && room.getPersons() <= roomPersonsMax && room.getCityName().equals(city) && room.getHotelName().equals(hotel)) {
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