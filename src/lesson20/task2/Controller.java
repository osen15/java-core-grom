package lesson20.task2;


public class Controller {


    // bad way
    private TransactionDAO transactionDAO = new TransactionDAO();
    private Utils utils = new Utils();


    public Transaction save(Transaction transaction) throws Exception {
        transactionDAO.checkTransaction(transaction);
        Transaction[] transactions = transactionDAO.getTransactionsPerDay(transaction.getDateCreated());


        if (transaction.getAmount() > utils.getTransactionAmountLimit()) {
            throw new LimitExceeded(transaction.getId() + " Amount of this transaction exceeded");
        }

        if (transactions.length + 1 > utils.getCountOfTransactionsPerDay()) {
            throw new LimitExceeded(transaction.getId() + " Count of transactions per day exceeded");
        }
        if (transactionDAO.transactionsPerDayAmount(transactions) + transaction.getAmount() > utils.getSumAmountOfTransactionsPerDay()) {
            throw new LimitExceeded(transaction.getId() + " Amount of transactions per day exceeded");
        }

        if (!transactionDAO.checkCity(transaction))
            throw new BadRequestException(transaction.getId() + " : no authorized city");

        return transactionDAO.save(transaction);

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
