package lesson22.HW;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) throws Exception {

        Transaction transaction1 = new Transaction(1, "Lviv", 50, "qwe", TransactionType.INCOME, new Date());
        Transaction transaction2 = new Transaction(2, "Kyiv", 100, "qwe", TransactionType.INCOME, new Date());
        Transaction transaction3 = new Transaction(3, "Tokio", 10, "qwe", TransactionType.INCOME, new Date());
        Transaction transaction4 = new Transaction(4, "New Yourk", 5, "qwe", TransactionType.INCOME, new Date());
        Transaction transaction5 = new Transaction(5, "Kharkiv", 6, "qwe", TransactionType.INCOME, new Date());
        Transaction transaction6 = new Transaction(6, "Lviv", 23, "qwe", TransactionType.INCOME, new Date());
        Transaction transaction7 = new Transaction(7, "Kyiv", 90, "qwe", TransactionType.INCOME, new Date());
        Transaction transaction8 = new Transaction(8, "Lviv", 34, "qwe", TransactionType.INCOME, new Date());
        Transaction transaction9 = new Transaction(9, "Odesa", 4, "qwe", TransactionType.INCOME, new Date());
        Transaction transaction10 = new Transaction(10, "Lviv", 12, "qwe", TransactionType.INCOME, new Date());



        

       // TransactionDAO transactionDAO = new TransactionDAO();
        
        
        System.out.println(TransactionDAO.save(transaction1));        // заповнюю масив
        TransactionDAO.save(transaction2);
       TransactionDAO.save(transaction3);
        TransactionDAO.save(transaction4);
        TransactionDAO.save(transaction5);
       TransactionDAO.save(transaction6);
        TransactionDAO.save(transaction7);
        System.out.println(Arrays.toString(TransactionDAO.getTransactions()));
        TransactionDAO.save(transaction7);                                     // перевірка коли всі параметри одного об"єкта дорівнюють другому




       System.out.println(Controller.saveTransaction(transaction9)) ;       // перевірено з усіма ексепшинами


        System.out.println(Arrays.toString(Controller.transactionList()));  // виводить масив всіх транзакцій , на разі одної


        System.out.println(Arrays.toString(Controller.transactionList("Odesa")));  // виводимо масив міст (фільтр)


        System.out.println(Arrays.toString(Controller.transactionList(4)));    // виводимо по фільтру масив відповідних сум.




    }



}
