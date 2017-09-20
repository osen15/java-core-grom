package lesson27.HW;

import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) throws Exception {

        Order order = new Order(1001, 1000, "USD", "MT", "AASDE23");
        LinkedListTest linkedListTest = new LinkedListTest();
        linkedListTest.useList(order);
        System.out.println(linkedListTest.getList());


    }

    LinkedList<Order> list = new LinkedList<>();

    private LinkedList useList(Order order) throws Exception {

        if (order == null) {
            throw new Exception("order doesn't can null");
        }

        for (int i = 0; i < 5; i++) {

            list.add(order);
        }

        list.add(1, order);

        list.remove(0);

        list.remove(order);

        list.addAll(list);

        LinkedList<Order> orders = new LinkedList<>(list.subList(0, 5));
        // System.out.println(orders);

        list.set(0, order);

        list.contains(order);

        Order[] array = new Order[list.size()];                          //toArray()
        list.toArray(array);
        //  System.out.println(Arrays.toString(array));

        list.clear();

        list = orders;


        //  if (list.size() >= 5) {
        //      throw new Exception("operation isn't allowed");
        //  }

        return list;


    }

    public LinkedList<Order> getList() {
        return list;
    }
}

















