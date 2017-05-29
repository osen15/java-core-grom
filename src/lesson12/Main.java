package lesson12;

public class Main {
    public static void main(String[] args) {
        Bank usBank = new USBank(1222, "USA", Currency.USD, 100, 1400, 4, 444343434);
        Bank euBank = new EUBank(1222, "Sweden", Currency.EUR, 100, 1400, 4, 444343434);
        Bank chinaBank = new ChinaBank(1222, "China", Currency.EUR, 100, 1400, 4, 444343434);

        User user1 = new User(1001, "Denis", 12200, 40, "GMD", 1500, usBank);
        User user2 = new User(1002, "Denis", 12200, 40, "GMD", 1500, euBank);
        User user3 = new User(1003, "Denis", 12200, 40, "GMD", 1500, euBank);
        User user4 = new User(1004, "Denis", 12200, 40, "GMD", 1500, euBank);
        User user5 = new User(1005, "Denis", 12200, 40, "GMD", 1500, chinaBank);
        User user6 = new User(1006, "Denis", 12200, 40, "GMD", 1500, chinaBank);

        BankSystem bankSystem = new UkrainianBankSystem();
        /*bankSystem.withdraw(user1, 100);
        bankSystem.withdraw(user2, 30000);
        System.out.println(user1.getBalance());
        System.out.println(user2.getBalance());

        bankSystem.withdraw(user3, 100);
        bankSystem.withdraw(user4, 30000);
        System.out.println(user3.getBalance());
        System.out.println(user4.getBalance());

        bankSystem.withdraw(user5, 100);
        bankSystem.withdraw(user6, 30000);
        System.out.println(user5.getBalance());
        System.out.println(user6.getBalance());

        bankSystem.fund(user1, 100);
        bankSystem.fund(user2, 30000);
        System.out.println(user1.getBalance());
        System.out.println(user2.getBalance());

        bankSystem.fund(user3, 100);
        bankSystem.fund(user4, 30000);
        System.out.println(user3.getBalance());
        System.out.println(user4.getBalance());

        bankSystem.fund(user5, 100);
        bankSystem.fund(user6, 30000);
        System.out.println(user5.getBalance());
        System.out.println(user6.getBalance());


*/
        bankSystem.transferMoney(user1, user2, 100);
        bankSystem.transferMoney(user3, user4, 200);
        bankSystem.transferMoney(user5, user6, 300);
        System.out.println(user1.getBalance());
        System.out.println(user2.getBalance());
        System.out.println(user3.getBalance());
        System.out.println(user4.getBalance());
        System.out.println(user5.getBalance());
        System.out.println(user6.getBalance());

       /* bankSystem.paySalary(user1);
        bankSystem.paySalary(user2);
        bankSystem.paySalary(user3);
        bankSystem.paySalary(user4);
        bankSystem.paySalary(user5);
        bankSystem.paySalary(user6);

        System.out.println(user1.getBalance());
        System.out.println(user2.getBalance());
        System.out.println(user3.getBalance());
        System.out.println(user4.getBalance());
        System.out.println(user5.getBalance());
        System.out.println(user6.getBalance());


      */


    }


}