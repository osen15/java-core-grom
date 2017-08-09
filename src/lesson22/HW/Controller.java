package lesson22.HW;


public class Controller {


    // bad way
    private TransactionDAO transactionDAO = new TransactionDAO();





    Transaction saveTransaction(Transaction transaction) throws Exception {
        return transactionDAO.save(transactionDAO.checkOnLimitsOfTransaction(transaction));

    }


    Transaction[] transactionList() throws Exception {
        if (transactionDAO.getTransactions() == null)
            throw new InternalServerException("invalid value");
        return transactionDAO.getTransactions();
    }


    Transaction[] transactionList(String city) throws Exception {
        if (transactionDAO.getTransactions() == null)
            throw new InternalServerException("invalid value");

        return transactionDAO.checkCityName(city);

    }

    Transaction[] transactionList(int amount) throws Exception {
        if (transactionDAO.getTransactions() == null)
            throw new InternalServerException("invalid value");

        return  transactionDAO.checkAmount(amount);
    }





}
