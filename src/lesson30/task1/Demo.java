package lesson30.task1;

public class Demo {
    public static void main(String[] args) throws Exception {


        Bank euBank = new USBank(1222, "Sweden", Currency.EUR, 100, 1400, 4, 4353543);

        User user = new User(1001, "Denis,", 12200, 40, "GMD", 1500, euBank);

        UkrainianBankSystem ukrainianBankSystem = new UkrainianBankSystem();

        ukrainianBankSystem.withdraw(user, 150);

        Thread.sleep(2000);   // метод зупиняє програму на 2000 мс.

        ukrainianBankSystem.withdraw(user, 10);

        System.out.println(ukrainianBankSystem.getTransactions());

    }


}
