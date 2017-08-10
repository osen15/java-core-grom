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

    public int getLimitSimpleTransactionAmount() {
        return limitSimpleTransactionAmount;
    }

    public int getLimitTransactionsPerDayCount() {
        return limitTransactionsPerDayCount;
    }

    public int getLimitTransactionsPerDayAmount() {
        return limitTransactionsPerDayAmount;
    }

    public String[] getCities() {
        return cities;
    }
}
