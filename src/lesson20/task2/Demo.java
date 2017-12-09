package lesson20.task2;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) throws Exception {

        Transaction transaction1 = new Transaction(1, "Lviv", 50, "qwe", TransactionType.INCOME, new Date());
        Transaction transaction2 = new Transaction(2, "Kiev", 20, "qwe", TransactionType.INCOME, new Date());
        Transaction transaction3 = new Transaction(3, "Tokio", 10, "qwe", TransactionType.INCOME, new Date());
        Transaction transaction4 = new Transaction(4, "New Yourk", 5, "qwe", TransactionType.INCOME, new Date());
        Transaction transaction5 = new Transaction(5, "Kharkiv", 6, "qwe", TransactionType.INCOME, new Date());
        Transaction transaction6 = new Transaction(6, "Lviv", 23, "qwe", TransactionType.INCOME, new Date());
        Transaction transaction7 = new Transaction(7, "Kiev", 8, "qwe", TransactionType.INCOME, new Date());
        Transaction transaction8 = new Transaction(8, "Kiev", 34, "qwe", TransactionType.INCOME, new Date());
        Transaction transaction9 = new Transaction(9, "Odesa", 20, "qwe", TransactionType.INCOME, new Date());
        Transaction transaction10 = new Transaction(10, "Kiev", 12, "qwe", TransactionType.INCOME, new Date());


        Controller controller = new Controller();
        Utils utils = new Utils();

        TransactionDAO transactionDAO = new TransactionDAO();
        System.out.println(controller.save(transaction9));        // заповнюю масив
        System.out.println(controller.save(transaction8));
        System.out.println(controller.save(transaction7));
        // Sys.out.println(controller.Save(transaction2));
        //  transactionDAO.Save(transaction5);
        // transactionDAO.Save(transaction6);
        //  transactionDAO.Save(transaction7);

        // перевірка коли всі параметри одного об"єкта дорівнюють другому

        System.out.println(Arrays.toString(controller.transactionList()));


        //  Sys.out.println(controller.saveTransaction(transaction9));          // перевірено з усіма ексепшинами


        //  Sys.out.println(Arrays.toString(controller.transactionList()));  // виводить масив всіх транзакцій , на разі одної


          System.out.println(Arrays.toString(controller.transactionList("Kiev")));  // виводимо масив міст (фільтр)


         //  Sys.out.println(Arrays.toString(controller.transactionList(20)));    // виводимо по фільтру масив відповідних сум.
        // Sys.out.println(Arrays.toString(utils.getCities()));
//

       // Sys.out.println(Arrays.toString(transactionDAO.getTransactionsPerDay(transaction10.getDateCreated())));
    }


}
