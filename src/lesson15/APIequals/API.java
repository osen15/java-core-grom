package lesson15.APIequals;


import lesson11.Room;

public interface API {

    lesson11.Room[] findRooms(int price, int persons, String city, String hotel);
    Room[] getAll();



}
