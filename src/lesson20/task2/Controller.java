package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServeException;
import lesson20.task2.exception.LimitExceeded;


public class Controller {


    // bad way
    private TransactionDAO transactionDAO = new TransactionDAO();

    private Utils utils = new Utils();


    public Controller() {
        utils.setCountOfTransactionsPerDay(30);
        utils.setSumAmountOfTransactionsPerDay(100);
        utils.setTransactionAmountLimit(40);
        utils.setCitiesAllowed(new String[]{"Kiev", "Odesa", "Mykolayiv"});


    }

    Transaction saveTransaction(Transaction transaction) throws Exception {
        Transaction[] transactions = transactionDAO.getTransactionsPerDay(transaction.getDateCreated());


        if (transaction.getAmount() > utils.getTransactionAmountLimit()) {
            throw new LimitExceeded("Amount of this transaction exceeded");
        }

        if (transactions.length + 1 > utils.getCountOfTransactionsPerDay()) {
            throw new LimitExceeded("Count of transactions per day exceeded");
        }
        if (tranactionsPerDayAmount(transactions) + transaction.getAmount() > utils.getSumAmountOfTransactionsPerDay()) {
            throw new LimitExceeded("Amount of transactions per day exceeded");
        }

        for (String city : utils.getCitiesAllowed()) {
            if (transaction.getCity().equals(city)) {
                transactionDAO.save(transaction);
                return transaction;
            }
        }
        throw new BadRequestException(transaction.getCity() + " : no authorized city");

    }


    Transaction[] allTransactionsList() throws Exception {
        if (transactionDAO.getTransactions().length == 0)
            throw new InternalServeException("List with transactions is empty");
        return transactionDAO.getTransactions();
    }


    Transaction[] allTransactionList(String city) throws Exception {

        if (transactionDAO.getTransactions().length == 0)
            throw new InternalServeException("List with transactions is empty");

        if (city == null)
            throw new BadRequestException("The city can not be null");

        int count = 0;
        for (Transaction transaction : transactionDAO.getTransactions()) {
            if (transaction != null && transaction.getCity().equals(city))
                count++;
        }
        Transaction[] result = new Transaction[count];
        if (result.length == 0)
            throw new BadRequestException(city + " : no authorized city");

        int index = 0;
        for (Transaction transaction : transactionDAO.getTransactions()) {
            if (transaction != null && transaction.getCity().equals(city))
                result[index] = transaction;
            index++;
        }


        return result;
    }

    Transaction[] allTransactionList(int amount) throws Exception {

        if (transactionDAO.getTransactions().length == 0)
            throw new InternalServeException("List with transactions is empty");

        if (amount < 0)
            throw new InternalServeException(amount + " :invalid value");

        int count = 0;
        for (Transaction transaction : transactionDAO.getTransactions()) {
            if (transaction != null && transaction.getAmount() == amount)
                count++;
        }
        Transaction[] result = new Transaction[count];
        if (result.length == 0)
            throw new Exception("Transfers on amount: " + amount  + " were not found");
        int index = 0;
        for (Transaction transaction : transactionDAO.getTransactions()) {
            if (transaction != null && transaction.getAmount() == amount)
                result[index] = transaction;
            index++;
        }


        return result;
    }


    private int tranactionsPerDayAmount(Transaction[] transactions) {
        int amount = 0;
        for (Transaction tr : transactions) {
            if (tr != null)
            amount += tr.getAmount();
        }
        return amount;
    }


}
