package lesson22.HW;

public class Utils {

    private static int sumAmountOfTransactionsPerDay;
    private static int countOfTransactionsPerDay;
    private static int transactionAmountLimit;
    private static String[] citiesAllowed;

    public static int getSumAmountOfTransactionsPerDay() {
        return sumAmountOfTransactionsPerDay;
    }

    public static void setSumAmountOfTransactionsPerDay(int sumAmountOfTransactionsPerDay) {
        Utils.sumAmountOfTransactionsPerDay = sumAmountOfTransactionsPerDay;
    }

    public static int getCountOfTransactionsPerDay() {
        return countOfTransactionsPerDay;
    }

    public static void setCountOfTransactionsPerDay(int countOfTransactionsPerDay) {
        Utils.countOfTransactionsPerDay = countOfTransactionsPerDay;
    }

    public static int getTransactionAmountLimit() {
        return transactionAmountLimit;
    }

    public static void setTransactionAmountLimit(int transactionAmountLimit) {
        Utils.transactionAmountLimit = transactionAmountLimit;
    }

    public static String[] getCitiesAllowed() {
        return citiesAllowed;
    }

    public static void setCitiesAllowed(String[] citiesAllowed) {
        Utils.citiesAllowed = citiesAllowed;
    }
}
