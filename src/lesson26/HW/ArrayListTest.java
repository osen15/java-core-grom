package lesson26.HW;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) throws Exception {
        Order order1 = new Order(1001, 19, "www", "eee", "ttt");
        Order order2 = new Order(1001, 19, "www", "eee", "ttt");
        Order order3 = new Order(1001, 19, "www", "eee", "ttt");
        Order order4 = new Order(1001, 19, "www", "eee", "ttt");
        Order order5 = new Order(1001, 19, "www", "eee", "ttt");


        ArrayListTest arrayListTest = new ArrayListTest();
        arrayListTest.useList(order1);
        //  arrayListTest.useList(null);
        // arrayListTest.useList(order3);
        // arrayListTest.useList(order4);
        // arrayListTest.useList(order5);
        System.out.println(arrayListTest.list.toString());

        //  arrayListTest.list.remove(order1);                                                //remove()
        //  System.out.println(arrayListTest.list.toString());

        //  arrayListTest.list.add(2, order2);                                         //add()
        //  System.out.println(arrayListTest.list.toString());

        //   arrayListTest.list.remove(1);                                              //remove()
        //   System.out.println(arrayListTest.list.toString());

        //   ArrayList<Order> list3 = new ArrayList<>(arrayListTest.list.subList(1, 2));      //subList()
        //   System.out.println(list3);

        //   arrayListTest.list.set(1, order5);                                               //set()
        //   System.out.println(arrayListTest.list.toString());

        //   System.out.println(arrayListTest.list.contains(order4));                        //contains()


        //    Order[] orders = new Order[arrayListTest.list.size()];                          //toArray()
        //    arrayListTest.list.toArray(orders);
        //    System.out.println(Arrays.toString(orders));

        //    arrayListTest.list.clear();                                                     //clear()
        //   System.out.println(arrayListTest.list);


        // ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 7, 5));
        // ArrayList<Integer> list2 = new ArrayList<>(list1.subList(1, 4));
        // System.out.println(list2);


    }


    private ArrayList<Order> list = new ArrayList<>();

  public  ArrayList useList(Order order) throws Exception {


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

        ArrayList<Order> orders = new ArrayList<>(list.subList(0, 5));
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


}
