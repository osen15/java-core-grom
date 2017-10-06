package lesson30.task2;

import java.util.LinkedList;

public class CustomerDAO {


  private   LinkedList<Customer> customers = new LinkedList<>();




    public LinkedList<Customer> addCustomers() {
        Customer customer1 = new Customer("AMZ", "USA", 10000);
        Customer customer2 = new Customer("123", "USA", 20000);
        Customer customer3 = new Customer("654", "Germany", 30000);
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        return customers;

    }

    public Customer findByName(String customerName) throws  Exception{
       if (customerName == null)
           throw  new  Exception("name is: " + customerName);
       for (Customer customer : getCustomers()){
           if (customer != null && customer.getName().equals(customerName))
               return customer;
       }

       throw new Exception("customer can't found");
    }

    public LinkedList<Customer> getCustomers(){
        return customers;
    }


}
