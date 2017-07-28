package lesson20.task2;

import lesson20.task2.exeption.BadRequestExeption;
import lesson20.task2.exeption.InternalServelExeption;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {


    private Transaction[] transactions = new Transaction[10];


    public Transaction save(Transaction transaction) throws Exception {
        //  if (transactions == null)
        //      throw new BadRequestExeption("array is null");
        //  if (transactions.length == 0)
        //      throw new InternalServelExeption(transactions.length + " :invalid value");
        if (transaction == null)
            throw new BadRequestExeption("Can't save null transaction");
        if (transaction.getAmount() < 0)
            throw new InternalServelExeption(transaction.getAmount() + " :invalid value");
        if (transaction.getCity() == null)
            throw new BadRequestExeption("The city can not be null");
        if (transaction.getId() <= 0)
            throw new InternalServelExeption(transaction.getId() + " :invalid value");
        if (transaction.getDateCreated() == null)
            throw new BadRequestExeption("Date is null");
        for (Transaction tr : transactions) {
            if (tr != null && tr.equals(transaction))
                throw new BadRequestExeption(transaction + " already exists");
        }
        int index = 0;
        for (Transaction tr : transactions) {
            if (tr == null) {
                transactions[index] = transaction;
                return transactions[index];
            }
            index++;
        }

        throw new InternalServelExeption("Not enough space to save " + transaction.getId());
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
