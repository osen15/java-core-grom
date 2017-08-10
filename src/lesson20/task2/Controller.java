package lesson20.task2;


public class Controller {


    // bad way
    private TransactionDAO transactionDAO = new TransactionDAO();





    Transaction save(Transaction transaction) throws Exception {
    return transactionDAO.save(transactionDAO.checkOnLimitsOfTransaction(transaction));

    }


    Transaction[] transactionList() throws Exception {
        if (transactionDAO.transactionList() == null)
            throw new InternalServerException("invalid value");
        return transactionDAO.transactionList();
    }


    Transaction[] transactionList(String city) throws Exception {
        if (transactionDAO.transactionList() == null)
            throw new InternalServerException("invalid value");

      return transactionDAO.transactionList(city);

    }

    Transaction[] transactionList(int amount) throws Exception {
        if (transactionDAO.transactionList() == null)
            throw new InternalServerException("invalid value");

        return  transactionDAO.transactionList(amount);
    }





}
