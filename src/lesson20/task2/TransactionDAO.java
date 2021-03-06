package lesson20.task2;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {


    private Utils utils = new Utils();

    private Transaction[] transactions = new Transaction[10];


    public Transaction save(Transaction transaction) throws Exception {
        validate(transaction);
        if (transactions == null)
            throw new BadRequestException("array is null");
        int index = 0;
        for (Transaction tr : transactions) {
            if (tr == null) {
                transactions[index] = transaction;
                return transactions[index];
            }
            index++;
        }


        throw new InternalServerException("Not enough space to Save transaction " + transaction.getId());
    }


    public Transaction[] getTransactions() {
        return transactions;
    }

    public Transaction[] transactionList(String city) throws Exception {      //метод валідації по назві міста
        if (transactions == null)
            throw new BadRequestException("array is null");
        int count = 0;
        if (city == null)
            throw new BadRequestException("The city can not be null");
        for (Transaction transaction : transactions) {

            if (transaction != null && transaction.getCity().equals(city)) {
                count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null && transaction.getCity().equals(city)) {
                result[index] = transaction;
                index++;
            }
        }


        return result;


    }

    public Transaction[] transactionList(int amount) throws Exception {    // метод валідації по сумі
        if (transactions == null)
            throw new BadRequestException("array is null");
        int count = 0;
        if (amount < 0)
            throw new InternalServerException(amount + " :invalid value");
        for (Transaction transaction : transactions) {
            if (transaction != null && transaction.getAmount() == amount)
                count++;
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null && transaction.getAmount() == amount) {
                result[index] = transaction;
                index++;
            }
        }


        return result;

    }


    public Transaction[] transactionList() throws Exception { // всі транзакції

        if (transactions == null)
            throw new BadRequestException("array is null");
        int count = 0;

        for (Transaction transaction : transactions) {
            if (transaction != null)
                count++;
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                result[index] = transaction;
                index++;
            }
        }


        return result;

    }

    private void checkTransaction(Transaction transaction) throws Exception {
        if (transactions == null) {
            throw new BadRequestException("array is null");
        }
        if (transaction == null) {
            throw new BadRequestException("Can't Save null transaction");
        }
        if (transaction.getAmount() < 0) {
            throw new BadRequestException(transaction.getId() + " :invalid value");
        }
        if (transaction.getCity() == null) {
            throw new BadRequestException("The city can not be null");
        }
        if (transaction.getId() <= 0) {
            throw new InternalServerException(transaction.getId() + " :invalid value");
        }
        if (!checkTransactionType(transaction)) {
            throw new BadRequestException(transaction.getId() + " transaction type is null");
        }
        if (transaction.getDateCreated() == null) {
            throw new BadRequestException(transaction.getId() + " Date is null");
        }
        if (transaction.getDescription() == null) {
            throw new BadRequestException(transaction.getId() + " Description is null");
        }
        if (theSameTransaction(transaction)) {
            throw new BadRequestException(transaction.getId() + " already exists");
        }
    }

    public void validate(Transaction transaction) throws Exception {

        checkTransaction(transaction);


        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount()) {
            throw new LimitExceeded(transaction.getId() + " Amount of this transaction exceeded");
        }

        if (getTransactionsPerDay(transaction.getDateCreated()).length + 1 > utils.getLimitTransactionsPerDayCount()) {
            throw new LimitExceeded(transaction.getId() + " Count of transactions per day exceeded");
        }
        if (transactionsPerDayAmount(getTransactionsPerDay(transaction.getDateCreated())) + transaction.getAmount() > utils.getLimitTransactionsPerDayAmount()) {
            throw new LimitExceeded(transaction.getId() + " Amount of transactions per day exceeded");
        }

        if (!checkCity(transaction)) {
            throw new BadRequestException(transaction.getId() + " : no authorized city");
        }

    }


    public Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) throws Exception {
        if (transactions == null)
            throw new BadRequestException("array is null");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());


                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    count++;
            }

        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }
            }
        }


        return result;
    }


    private int transactionsPerDayAmount(Transaction[] transactions) { // сума грошей за день
        int amount = 0;
        for (Transaction tr : transactions) {
            if (tr != null)
                amount += tr.getAmount();
        }
        return amount;
    }

    private boolean checkCity(Transaction transaction) {  //метод перевіряє чи таке місто є в списку
        for (String city : utils.getCities()) {
            if (city.equals(transaction.getCity()))
                return true;

        }
        return false;
    }

    private boolean theSameTransaction(Transaction transaction) { //метод перевіряє чи є в списку одинакова транзакція
        for (Transaction tr : transactions) {
            if (tr != null && tr.equals(transaction))
                return true;
        }
        return false;
    }

    private boolean checkTransactionType(Transaction transaction) {
        return (transaction.getType() == TransactionType.INCOME || transaction.getType() == TransactionType.OUTCOME);

    }
}
