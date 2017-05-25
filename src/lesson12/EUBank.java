package lesson12;


public class EUBank extends Bank {
    public EUBank(long id, String bankCountry, Currency currency, int numberOfEmployee, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployee, avrSalaryOfEmployee, rating, totalCapital);
    }

    @Override
    public int getLimitOfWithdrawal() {
        return getCurrency() == Currency.USD ? 2000 : 2200;
    }

    @Override
    public int getLimitOfFunding() {
        return getCurrency() == Currency.EUR ? 20000 : 10000;
    }

    @Override
    public double getMonthlyRate() {
        return getCurrency() == Currency.USD ? 0 : 0.01;
    }

    @Override
    public double getCommission(int amount) {
        if (getCurrency() == Currency.USD) {
            if (amount <= 1000)
                return 0.05;
            else
                return 0.07;
        } else {
            if (amount <= 1000)
                return 0.02;

            else
                return 0.04;
        }
    }
}