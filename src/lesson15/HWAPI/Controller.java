package lesson15.HWAPI;


public class Controller {

    private API[] apis = new API[3];


    public Controller(API[] apis) {

        this.apis = apis;

    }


    public Room[] requestRooms(int price, int persons, String city, String hotel) {
        checkOnLegalValue(price, persons);
        Room[] rooms = new Room[findRoomsByParams(price, persons, city, hotel)];

        int index = 0;
        if (apis != null && checkOnLegalValue(price, persons))
            for (API api : apis) {
                if (api != null)

                    for (Room room : api.findRooms(price, persons, city, hotel)) {

                        rooms[index] = room;

                        index++;

                    }

            }

        return rooms;

    }






    private int findRoomsByParams(int price, int persons, String city, String hotel) {

        int count = 0;
        if (apis != null)
            for (API api : apis) {
                if (api != null)
                    count += api.findRooms(price, persons, city, hotel).length;

            }

        return count;

    }


    public Room[] check(Room[] roomsApi1, Room[] roomsApi2) {

        int count = 0;
        if (roomsApi1 != null && roomsApi2 != null)
            for (Room roomApi1 : roomsApi1) {

                for (Room roomApi2 : roomsApi2) {

                    if (roomApi1.equals(roomApi2) && roomApi1.hashCode() == roomApi2.hashCode()) {

                        count++;

                    }

                }
                if (count == 0) {
                    return null;

                }
            }


        Room[] res = new Room[count];

        int index = 0;
        if (roomsApi1 != null && roomsApi2 != null)
            for (Room roomApi1 : roomsApi1) {

                for (Room roomApi2 : roomsApi2) {

                    if (roomApi1.getId() == roomApi2.getId()) {

                        res[index] = roomApi1;

                    }

                }

            }


        return res;

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