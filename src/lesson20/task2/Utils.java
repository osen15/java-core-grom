package lesson20.task2;

public class Utils {

    private int limitSimpleTransactionAmount;
    private int limitTransactionsPerDayCount;
    private int limitTransactionsPerDayAmount;
    private String[] cities;


    public Utils() {
        this.limitSimpleTransactionAmount = 1000;
        this.limitTransactionsPerDayCount = 1000;
        this.limitTransactionsPerDayAmount = 1000;
        this.cities = new String[]{"Kiev", "Odesa", "Mykolayiv"};
    }

    public String[] getCitiesAllowed() {
        return cities;
    }


    public int getTransactionAmountLimit() {
        return limitTransactionsPerDayAmount;
    }


    public int getSumAmountOfTransactionsPerDay() {
        return limitSimpleTransactionAmount;
    }


    public int getCountOfTransactionsPerDay() {
        return limitTransactionsPerDayCount;
    }


}
