package lesson35.controller;

import lesson35.service.OrderService;

public class OrderController {


    public static void bookRoom(long roomId, long userId, long hotelId) throws Exception {
        OrderService.bookRoom(roomId, userId, hotelId);

    }


    public static void cancelReservation(long roomId, long userId) throws Exception {
        OrderService.cancelReservation(roomId, userId);

    }
}
