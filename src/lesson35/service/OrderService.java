package lesson35.service;

import lesson35.DAO.OrderDAO;
import lesson35.DAO.utils.ConvertListInStrBuff;
import lesson35.DAO.utils.WriteOldContentInToFile;
import lesson35.model.Order;
import lesson35.service.utils.IDGenerate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class OrderService {
    private static Order order = new Order();
    private static final String OrderDB = "C://OrderDB.txt";


    public static void bookRoom(long roomId, long userId, long hotelId) throws Exception {

        System.out.println("Auto - Generate ID");
        order.setId(IDGenerate.generateID());
        System.out.println("OK!");
        System.out.println("Find user");
        order.setUser(UserService.findUserByID(userId));
        System.out.println("OK!");
        System.out.println("Find hotel");
        HotelService.findHotelByID(hotelId);
        System.out.println("OK!");
        System.out.println("Find room");
        order.setRoom(RoomService.findRoomByID(roomId));
        System.out.println("OK!");

        BufferedReader brDateFrom = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter a date From in format:    dd-MM-yyyy  example: 01-01-2018");
            Date dateFrom =  new SimpleDateFormat("dd-MM-yyyy").parse(brDateFrom.readLine());
            if (RoomService.findRoomByID(roomId).getDateAvailableFrom().getTime() <=
                     dateFrom.getTime())
                order.setDateFrom(dateFrom);
            else throw new Exception("Room: " + roomId + " is not avalible ");
        } catch (IOException e) {
            System.err.println("Can not set value ");
        } catch (NullPointerException e) {
            System.err.println("Room is null");
        } catch (NumberFormatException e) {
            System.err.println("Wrong format");
        }
        BufferedReader brDateTo = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter a date To in format:    dd-MM-yyyy  example: 01-01-2018");
            Date dateTo =  new SimpleDateFormat("dd-MM-yyyy").parse(brDateTo.readLine());
            order.setDateTo(dateTo);
            RoomService.findRoomByID(roomId).setDateAvailableFrom(dateTo);
        } catch (IOException e) {
            System.err.println("Can not set value ");
        } catch (NullPointerException e) {
            System.err.println("Room is null");
        } catch (NumberFormatException e) {
            System.err.println("Wrong format");
        }
        BufferedReader brPaid = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Payment amount. Enter amount: " + RoomService.findRoomByID(roomId).getPrice());
            order.setMoneyPaid(Double.parseDouble(brPaid.readLine()));
        } catch (IOException e) {
            System.err.println("Can not set value ");
        } catch (NullPointerException e) {
            System.err.println("Room is null");
        } catch (NumberFormatException e) {
            System.err.println("Wrong format");
        }
        System.out.println("Operation is complite");
        brDateFrom.close();
        brDateTo.close();
        brPaid.close();
        OrderDAO.addOrder(order);

    }


   public static void cancelReservation(long roomId, long userId) throws Exception {
        ArrayList<Order> orders = new ArrayList<>();
        StringBuffer oldDatainBuff = ConvertListInStrBuff.listInStrBuff(OrderDAO.readFromFile());
        for (Order order : OrderDAO.readFromFile()) {
            if (order.getUser().getId() == userId && order.getRoom().getId() == roomId) {
                continue;
            }

            orders.add(order);
        }
       System.out.println(orders.toString());
        if (OrderDAO.readFromFile().size() == orders.size()) {
            throw new Exception("reservation not found");
        }

        try {
            OrderDAO.WriteNewContentInFile(orders);

        } catch (IOException e) {
            WriteOldContentInToFile.writeOldContentToFile(oldDatainBuff, OrderDB);
            System.err.println("Can not delete reservation");
        }

    }

}

