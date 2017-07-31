package lesson20.task2;


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


    Transaction[] transactionList() throws Exception {
        if (transactionDAO.getTransactions() == null)
            throw new BadRequestException("invalid value");
        return transactionDAO.getTransactions();
    }


    Transaction[] transactionList(String city) throws Exception {
        if (transactionDAO.getTransactions() == null)
            throw new BadRequestException("invalid value");

        int count = 0;
        for (Transaction transaction : transactionDAO.getTransactions()) {
            if (transactionDAO.checkCityName(city))
                count++;
        }
        Transaction[] result = new Transaction[count];
        if (result.length == 0)
            throw new BadRequestException(city + " : no authorized city");

        int index = 0;
        for (Transaction transaction : transactionDAO.getTransactions()) {
            if (transactionDAO.checkCityName(city))
                result[index] = transaction;
            index++;
        }


        return result;
    }

    Transaction[] transactionList(int amount) throws Exception {
        if (transactionDAO.getTransactions() == null)
            throw new BadRequestException("invalid value");

        int count = 0;
        for (Transaction transaction : transactionDAO.getTransactions()) {
            if (transactionDAO.checkAmount(amount))
                count++;
        }
        Transaction[] result = new Transaction[count];
        if (result.length == 0)
            throw new Exception("Transfers on amount: " + amount + " were not found");
        int index = 0;
        for (Transaction transaction : transactionDAO.getTransactions()) {
            if (transactionDAO.checkAmount(amount))
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
