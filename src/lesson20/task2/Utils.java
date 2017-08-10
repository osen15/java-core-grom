package lesson20.task2;

public class Utils {

    private int sumAmountOfTransactionsPerDay;
    private int limitTransactionsPerDayCount;
    private int limitTransactionsPerDayAmount;
    private String[] citiesAllowed;


    public Utils() {
        this.sumAmountOfTransactionsPerDay = 1000;
        this.limitTransactionsPerDayCount = 1000;
        this.limitTransactionsPerDayAmount = 1000;
        this.citiesAllowed = new String[]{"Kiev", "Odesa", "Mykolayiv"};
    }

    public String[] getCitiesAllowed() {
        return citiesAllowed;
    }


    public int getTransactionAmountLimit() {
        return limitTransactionsPerDayAmount;
    }


    public int getSumAmountOfTransactionsPerDay() {
        return sumAmountOfTransactionsPerDay;
    }


    public int getCountOfTransactionsPerDay() {
        return limitTransactionsPerDayCount;
    }


}
