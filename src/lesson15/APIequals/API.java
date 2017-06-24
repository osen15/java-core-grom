package lesson15.APIequals;


public interface API {

    Room[] findRooms(int price, int persons, String city, String hotel);
    Room[] getAll();



}
