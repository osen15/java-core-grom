package lesson35.demo;

import lesson35.service.OrderService;

public class DemoOrder {

    public static void main(String[] args) throws Exception {
       // OrderService.bookRoom(1,1,1);
        OrderService.cancelReservation(1,1);
       // System.out.println(OrderDAO.readFromFile());
    }

}
