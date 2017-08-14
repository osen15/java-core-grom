package lesson20.task2;

public class Utils {

    private int limitSimpleTransactionAmount = 40;
    private int limitTransactionsPerDayCount = 10;
    private int limitTransactionsPerDayAmount = 100;
    private String[] cities = new String[]{"Kiev", "Odesa", "Mykolayiv"};


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
