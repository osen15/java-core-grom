package lesson22.HW;


public class Controller {


    // bad way
  //  private TransactionDAO transactionDAO = new TransactionDAO();

  //  private Utils utils = new Utils();


    public Controller() {
        Utils.setCountOfTransactionsPerDay(30);
        Utils.setSumAmountOfTransactionsPerDay(100);
        Utils.setTransactionAmountLimit(40);
        Utils.setCitiesAllowed(new String[]{"Kiev", "Odesa", "Mykolayiv"});


    }

   static Transaction saveTransaction(Transaction transaction) throws Exception {
        Transaction[] transactions = TransactionDAO.getTransactionsPerDay(transaction.getDateCreated());


        if (transaction.getAmount() > Utils.getTransactionAmountLimit()) {
            throw new LimitExceeded("Amount of this transaction exceeded");
        }

        if (transactions.length + 1 > Utils.getCountOfTransactionsPerDay()) {
            throw new LimitExceeded("Count of transactions per day exceeded");
        }
        if (tranactionsPerDayAmount(transactions) + transaction.getAmount() > Utils.getSumAmountOfTransactionsPerDay()) {
            throw new LimitExceeded("Amount of transactions per day exceeded");
        }

        for (String city : Utils.getCitiesAllowed()) {
            if (transaction.getCity().equals(city)) {
                TransactionDAO.save(transaction);
                return transaction;
            }
        }
        throw new BadRequestException(transaction.getCity() + " : no authorized city");

    }


 public   static Transaction[] transactionList() throws Exception {
        if (TransactionDAO.getTransactions() == null)
            throw new BadRequestException("invalid value");
        return TransactionDAO.getTransactions();
    }


 public   static Transaction[] transactionList(String city) throws Exception {
        if (TransactionDAO.getTransactions() == null)
            throw new BadRequestException("invalid value");

      return TransactionDAO.checkCityName(city);

    }

 public   static Transaction[] transactionList(int amount) throws Exception {
        if (TransactionDAO.getTransactions() == null)
            throw new BadRequestException("invalid value");

        return  TransactionDAO.checkAmount(amount);
    }


    private static int tranactionsPerDayAmount(Transaction[] transactions) {
        int amount = 0;
        for (Transaction tr : transactions) {
            if (tr != null)
                amount += tr.getAmount();
        }
        return amount;
    }


}
