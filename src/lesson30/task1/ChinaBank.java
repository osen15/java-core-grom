package lesson30.task1;

public class ChinaBank extends Bank {
    public ChinaBank(long id, String bankCountry, Currency currency, int numberOfEmployee, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployee, avrSalaryOfEmployee, rating, totalCapital);
    }

    @Override
    public int getLimitOfWithdrawal() {
        return getCurrency() == Currency.USD ? 100 : 150;
    }

    @Override
    public int getLimitOfFunding() {
        return getCurrency() == Currency.EUR ? 5000 : 10000;
    }

    @Override
    public double getMonthlyRate() {
        return getCurrency() == Currency.USD ? 0.01 : 0;
    }

    @Override
    public double getCommission(int amount) {
        if (getCurrency() == Currency.USD) {
            if (amount <= 1000)
                return 0.03;
            else
                return 0.05;
        } else {
            if (amount <= 1000)
                return 0.1;

            else
                return 0.11;
        }
    }
}
