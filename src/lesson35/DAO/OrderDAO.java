package lesson35.DAO;

import lesson35.DAO.utils.ReWriteFile;
import lesson35.DAO.utils.ReadFromFile;
import lesson35.DAO.utils.ValidateFileDb;
import lesson35.DAO.utils.WriteToFile;
import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.model.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class OrderDAO {

    private static int lineCounter = 1;
    private static final String OrderDB = "C://OrderDB.txt";

    public static Order addOrder(Order order) throws Exception {
        ValidateFileDb.validate(OrderDB);
        return WriteToFile.WriteToFile(order, OrderDB);
    }


    public static ArrayList<Order> getAll() throws Exception {
        ValidateFileDb.validate(OrderDB);
        ArrayList<Order> orders = new ArrayList<>();

        for (String line : ReadFromFile.readFromFile(OrderDB)) {
            orders.add(orderMapper(line));
        }
        return orders;


    }

    public static void deleteOrder(ArrayList<Order> orders) throws Exception {
        ReWriteFile.reWriteFile(orders, OrderDB);
    }


    public static Order orderMapper(String line) throws Exception {
        String[] arrayOrder = line.split("\\, ");
        if (arrayOrder.length != 6) {
            throw new Exception("error in file: " + lineCounter);
        }
        lineCounter++;
        return new Order(Long.parseLong(arrayOrder[0]), new User(Long.parseLong(arrayOrder[1])),
                new Room(Long.parseLong(arrayOrder[2])), new SimpleDateFormat("dd-MM-yyyy").parse(arrayOrder[3]),
                new SimpleDateFormat("dd-MM-yyyy").parse(arrayOrder[4]), Double.parseDouble(arrayOrder[5]));

    }


}
