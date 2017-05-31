package lesson11;

public class TripAdvisorAPI implements API {
    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        checkOnLegalValue(price, persons);
        int index = 0;
        Room[] rooms1 = new Room[sizeArray(price, persons, city, hotel)];
        if (rooms != null && checkOnLegalValue(price, persons) == true)
            for (Room room : rooms) {
                if (room.getPrice() == price && room.getPersons() >= persons - 1 && room.getPersons() <= persons + 1 && room.getCityName() == city && room.getHotelName() == hotel)
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
        if (rooms != null)
            for (Room room : rooms) {
                if (room.getPrice() == price && room.getPersons() >= persons - 1 && room.getPersons() <= persons + 1 && room.getCityName() == city && room.getHotelName() == hotel)


                    count++;
            }
        return count;
    }

    private boolean checkOnLegalValue(int price, int persons) {
        if (price < 0 || persons < 0) {
            printIllegalValueMsg();

        }
        return true;
    }

    private void printIllegalValueMsg() {
        System.err.println("illegal value");
    }

}