package lesson22.HW;


public class Controller {


    public static Transaction saveTransaction(Transaction transaction) throws Exception {
        return TransactionDAO.save(TransactionDAO.checkOnLimitsOfTransaction(transaction));

    }


    public static Transaction[] transactionList() throws Exception {
        if (TransactionDAO.getTransactions() == null)
            throw new InternalServerException("invalid value");
        return TransactionDAO.getTransactions();
    }


    public static Transaction[] transactionList(String city) throws Exception {
        if (TransactionDAO.getTransactions() == null)
            throw new InternalServerException("invalid value");

        return TransactionDAO.checkCityName(city);

    }

    public static Transaction[] transactionList(int amount) throws Exception {
        if (TransactionDAO.getTransactions() == null)
            throw new InternalServerException("invalid value");

        return TransactionDAO.checkAmount(amount);
    }


}
