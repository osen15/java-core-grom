package lesson22.HW;

public class Utils {

    private static int sumAmountOfTransactionsPerDay;
    private static int countOfTransactionsPerDay;
    private static int transactionAmountLimit;
    private static String[] citiesAllowed;


    public Utils() {
        sumAmountOfTransactionsPerDay = 1000;
        countOfTransactionsPerDay = 1000;
        transactionAmountLimit = 1000;
        citiesAllowed = new String[]{"Kiev", "Odesa", "Mykolayiv"};
    }

    public static String[] getCitiesAllowed() {
        return citiesAllowed;
    }


    public static int getTransactionAmountLimit() {
        return transactionAmountLimit;
    }


    public static int getSumAmountOfTransactionsPerDay() {
        return sumAmountOfTransactionsPerDay;
    }


    public static int getCountOfTransactionsPerDay() {
        return countOfTransactionsPerDay;
    }


}
