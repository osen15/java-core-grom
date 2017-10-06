package lesson30.task1;

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

        //Завантаження null - юзера
        bankSystem.withdraw(null, 100);
        //Коли значення amount < 0
        bankSystem.withdraw(user1, -100);
        // Перевірка, коли баланс < 0
        User user7 = new User(1004, "Denis", -12200, 40, "GMD", 1500, euBank);
        bankSystem.withdraw(user7, 100);
        System.out.println(user1.getBalance());


        //Завантаження null - юзера
        bankSystem.fund(null, 100);

        // Коли значення amount < 0
        bankSystem.fund(null, -100);
        // Перевірка, коли баланс < 0
        User user8 = new User(1004, "Denis", -12200, 40, "GMD", 1500, euBank);
        bankSystem.withdraw(user8, 100);
        System.out.println(user8.getBalance());


        //Завантаження null - юзера1
        bankSystem.transferMoney(null, user2, 50);
        //Завантаження null - юзера2
        bankSystem.transferMoney(null, user2, 50);
        // Коли значення amount < 0
        bankSystem.transferMoney(user5, user2, 50);
        System.out.println(user5.getBalance() + " " + user2.getBalance());


        //Завантаження null - юзера
        bankSystem.paySalary(null,0);
        //Завантаження коли значення salary < 0
        User user9 = new User(1006, "Denis", 12200, 40, "GMD", -1500, chinaBank);
        System.out.println(user9.getBalance());
        // Тест коли баланс менший від нуля
        User user10 = new User(1006, "Denis", -12200, 40, "GMD", -1500, chinaBank);
        System.out.println(user10.getBalance());




    }


}