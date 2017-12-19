package lesson35.service;

import lesson35.DAO.OrderDAO;
import lesson35.DAO.utils.ConvertListInStrBuff;
import lesson35.DAO.utils.WriteOldContentInToFile;
import lesson35.model.Order;

import java.io.IOException;
import java.util.ArrayList;


public class OrderService {
    private static Order order = new Order();
    private static final String OrderDB = "C://OrderDB.txt";


    public static void bookRoom(long roomId, long userId, long hotelId) throws Exception {


        UserService.findUserByID(userId);
        HotelService.findHotelByID(hotelId);


        if (RoomService.findRoomByID(roomId).getDateAvailableFrom().getTime() >=
                order.getDateFrom().getTime())
            throw new Exception("Room: " + roomId + " is not avalible ");


        RoomService.findRoomByID(roomId).setDateAvailableFrom(order.getDateTo());


        if (RoomService.findRoomByID(roomId).getPrice() != order.getMoneyPaid())
            throw new Exception("Wrong amount");

        OrderDAO.addOrder(findOrderByID(order.getId()));

    }


    public static void cancelReservation(long roomId, long userId) throws Exception {
        ArrayList<Order> orders = new ArrayList<>(OrderDAO.getAll());

        StringBuffer oldDatainBuff = ConvertListInStrBuff.listInStrBuff(OrderDAO.getAll());
        for (Order order : orders) {

            if (order.getUser().getId() == UserService.findUserByID(userId).getId()
                    && order.getRoom().getId() == RoomService.findRoomByID(roomId).getId()) {

                orders.remove(order);
            }

        }

        try

        {
            OrderDAO.deleteOrder(orders);

        } catch (
                IOException e)

        {
            WriteOldContentInToFile.writeOldContentToFile(oldDatainBuff, OrderDB);
            System.err.println("Can not delete reservation");
        }

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

