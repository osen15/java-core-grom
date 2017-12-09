package lesson35.DAO;

import lesson35.DAO.utils.ValidateFileDb;
import lesson35.DAO.utils.WriteToFile;
import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.model.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class OrderDAO {

    private static int lineCounter = 1;
    private static final String OrderDB = "C://OrderDB.txt";

    public static Order addOrder(Order order) throws Exception {
        ValidateFileDb.validate(OrderDB);
        return WriteToFile.WriteToFile(order, OrderDB);
    }


    public static ArrayList<Order> readFromFile() throws Exception {

        ArrayList<Order> orders = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(OrderDB))) {
            String line;

            while ((line = br.readLine()) != null) {
                orders.add(orderMapper(line));

            }

        } catch (FileNotFoundException e) {
            lineCounter = 0;
            System.err.println("File not exist");
        } catch (IOException e) {
            lineCounter = 0;
            System.err.println("Reading from fileDB " + OrderDB + " failed");

        }
        lineCounter = 0;
        return orders;


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
