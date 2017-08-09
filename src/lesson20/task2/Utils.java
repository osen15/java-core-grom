package lesson20.task2;

public class Utils {

    private int sumAmountOfTransactionsPerDay;
    private int countOfTransactionsPerDay;
    private int transactionAmountLimit;
    private String[] citiesAllowed;


    public Utils() {
        this.sumAmountOfTransactionsPerDay = 1000;
        this.countOfTransactionsPerDay = 1000;
        this.transactionAmountLimit = 1000;
        this.citiesAllowed = new String[]{"Kiev", "Odesa", "Mykolayiv"};
    }

    public String[] getCitiesAllowed() {
        return citiesAllowed;
    }


    public int getTransactionAmountLimit() {
        return transactionAmountLimit;
    }


    public int getSumAmountOfTransactionsPerDay() {
        return sumAmountOfTransactionsPerDay;
    }


    public int getCountOfTransactionsPerDay() {
        return countOfTransactionsPerDay;
    }


}
