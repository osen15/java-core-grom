package lesson35.service;

import lesson35.DAO.OrderDAO;
import lesson35.DAO.utils.UpdateDB;
import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.model.User;
import lesson35.service.utils.IDGenerate;

import java.util.ArrayList;
import java.util.Date;


public class OrderService {

    private static final String RoomDB = "C://RoomDB.txt";
    private static User user = new User();
    private static Room room = new Room();


    public static void bookRoom(long roomId, long userId) throws Exception {


        UserService.findUserByID(userId);
        RoomService.findRoomByID(roomId);


        Order order = OrderDAO.addOrder(new Order(IDGenerate.generateID(), user, room,
                room.getDateAvailableFrom(), new Date(), room.getPrice()));
        room.setDateAvailableFrom(order.getDateTo());
        UpdateDB.updateDB(room, RoomDB);

    }


    public static void cancelReservation(long roomId, long userId) throws Exception {
        ArrayList<Order> orders = new ArrayList<>(OrderDAO.getAll());


        for (Order order : orders) {

            if (order.getUser().getId() == userId
                    && order.getRoom().getId() == roomId) {
                RoomService.findRoomByID(roomId).setDateAvailableFrom(new Date());

                orders.remove(order);
            }

        }


        OrderDAO.deleteOrder(orders);


    }

    public static Order findOrderByID(long id) throws Exception {
        for (Order order : OrderDAO.getAll()) {
            if (order.getId() == id) {
                return order;
            }
        }
        throw new Exception("Order: " + id + "already exists");

    }

}

