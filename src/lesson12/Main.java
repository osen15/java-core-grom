package lesson12;

public class Main {
    public static void main(String[] args) {
        Bank usBank = new USBank(1222, "USA", Currency.USD, 100, 1400, 4, 444343434);
        Bank euBank = new EUBank(1222, "Sweden", Currency.EUR, 100, 1400, 4, 444343434);
        Bank chinaBank = new ChinaBank(1222, "China", Currency.EUR, 100, 1400, 4, 444343434);

        User user1 = new User(1001, "Denis", 1000, 40, "GMD", 1500, usBank);
        User user2 = new User(1002, "Denis", 12200, 40, "GMD", 1500, euBank);
        User user3 = new User(1003, "Denis", 12200, 40, "GMD", 1500, euBank);
        User user4 = new User(1004, "Denis", 12200, 40, "GMD", 1500, euBank);
        User user5 = new User(1005, "Denis", 12200, 40, "GMD", 1500, chinaBank);
        User user6 = new User(1006, "Denis", 12200, 40, "GMD", 1500, chinaBank);

        BankSystem bankSystem = new UkrainianBankSystem();
       bankSystem.withdraw(null, 100);
        //Завантаження null - юзера
        //Коли значення amount < 0
        // Перевірка, коли баланс < 0
        System.out.println(user1.getBalance());


        bankSystem.fund(user2, 100);
         //Завантаження null - юзера
        // Коли значення amount < 0
        // Перевірка, коли баланс < 0
        System.out.println(user2.getBalance());


       bankSystem.transferMoney(user5, user2, 50);
        //Завантаження null - юзера1
        //Завантаження null - юзера2
        // Коли значення amount < 0
        System.out.println(user5.getBalance() + " " + user2.getBalance());

        bankSystem.paySalary(user3);
        //Завантаження null - юзера
        //Завантаження коли значення salary < 0
        // Тест на ліміт відправлення

        System.out.println(user3.getBalance());





    }


}