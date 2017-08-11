package lesson20.task2;


public class Controller {


    // bad way
    private TransactionDAO transactionDAO = new TransactionDAO();


    public Transaction save(Transaction transaction) throws Exception {



        return transactionDAO.save(transactionDAO.checkLimits(transaction));

    }


    public Transaction[] transactionList() throws Exception {

        return transactionDAO.transactionList();
    }


    public Transaction[] transactionList(String city) throws Exception {

        return transactionDAO.transactionList(city);

    }

    public Transaction[] transactionList(int amount) throws Exception {

        return transactionDAO.transactionList(amount);
    }


}
