package lesson29.HW;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;


public class HashSetTest {
    public static void main(String[] args) throws Exception {
        HashSet<Order> orderHashSet = new HashSet<>();
        HashSetTest hashSetTest = new HashSetTest();
        System.out.println(hashSetTest.useHahsSet(orderHashSet));

    }

    private HashSet<Order> useHahsSet(HashSet<Order> orders) throws Exception {
        if (orders == null)
            throw new Exception("can't be null");

        if (orders.size() != 0)
            throw new Exception("the size should be 0");


        for (int i = 0; i < 7; i++) {
            orders.add(new Order(1000 + i, 100 + i, "A", "B", "C"));  // додаємо елементи в Set


        }


        orders.remove(new Order(1000, 100, "A", "B", "C"));           // видаляє елемент

        System.out.println(orders);
        Object[] array = orders.toArray();                                                                       // Set  перетворюэмо в масив
        System.out.println(Arrays.toString(array));


        HashSet<Order> otherSomeOrders = new HashSet<>();
        otherSomeOrders.add(new Order(1001, 101, "A", "B", "C"));
        otherSomeOrders.add(new Order(1002, 102, "A", "B", "C"));
        otherSomeOrders.add(new Order(1003, 101, "A", "B", "C"));
        otherSomeOrders.add(new Order(1004, 101, "A", "B", "C"));
        otherSomeOrders.add(new Order(1005, 101, "A", "B", "C"));
        orders.retainAll(otherSomeOrders);                                                                       // Метод порійнює два Set і залишає в першому тільки однакові елементи


        Iterator<Order> orderIterator = orders.iterator();                                                       // Iterator
        while (orderIterator.hasNext())
        System.out.println(orderIterator.next().getItemName());


        return orders;

    }

}



















