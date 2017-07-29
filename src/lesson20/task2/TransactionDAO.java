package lesson20.task2;

import lesson20.task2.exception.BadRequestExсeption;
import lesson20.task2.exception.InternalServelExсeption;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {


    private Transaction[] transactions = new Transaction[10];


    public Transaction save(Transaction transaction) throws Exception {
        //  if (transactions == null)
        //      throw new BadRequestExсeption("array is null");
        //  if (transactions.length == 0)
        //      throw new InternalServelExсeption(transactions.length + " :invalid value");
        if (transaction == null)
            throw new BadRequestExсeption("Can't save null transaction");
        if (transaction.getAmount() < 0)
            throw new InternalServelExсeption(transaction.getAmount() + " :invalid value");
        if (transaction.getCity() == null)
            throw new BadRequestExсeption("The city can not be null");
        if (transaction.getId() <= 0)
            throw new InternalServelExсeption(transaction.getId() + " :invalid value");
        if (transaction.getDateCreated() == null)
            throw new BadRequestExсeption("Date is null");
        for (Transaction tr : transactions) {
            if (tr != null && tr.equals(transaction))
                throw new BadRequestExсeption(transaction + " already exists");
        }
        int index = 0;
        for (Transaction tr : transactions) {
            if (tr == null) {
                transactions[index] = transaction;
                return transactions[index];
            }
            index++;
        }

        throw new InternalServelExсeption("Not enough space to save " + transaction.getId());
    }


    public Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null)
            calendar.setTime(transaction.getDateCreated());
            int trMonth = calendar.get(Calendar.MONTH);
            int trDay = calendar.get(Calendar.DAY_OF_MONTH);

            if (trMonth == month && trDay == day)
                count++;
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null)
            calendar.setTime(transaction.getDateCreated());
            int trMonth = calendar.get(Calendar.MONTH);
            int trDay = calendar.get(Calendar.DAY_OF_MONTH);

            if (trMonth == month && trDay == day)
                result[index] = transaction;
            index++;

        }


        return result;

    }

    public Transaction[] getTransactions() {
        return transactions;
    }


}
