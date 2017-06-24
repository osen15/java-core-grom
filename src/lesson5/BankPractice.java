package lesson5;

import java.util.Arrays;

/**
 * Created by Masja on 31.03.2017.
 */
public class BankPractice {
    public static void main(String[] args) {
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, -99, 1200, -54, 0};
        System.out.println(Arrays.toString(findClientsByBalance(names, balances, -100)));
        System.out.println(Arrays.toString(findClientsWithNegativeByBalance(names, balances)));

       // depositMoney(names, balances, "Ann", 2000);
        System.out.println(Arrays.toString(balances));
        System.out.println(withdraw(names, balances, "Ann", 50));

    }
    static String[] findClientsByBalance(String[] cliens, int[] balances, int n) {
        // String[] results = new String[cliens.length];
        // 1. знаходимо кількість результатів
        // 2. створюємо масив з довжиною результатів
        // 3. записуєм результати


        //1
        int count = 0;
        for (int balance : balances) {
            if (balance >= n)
                count++;
        }
        //2
        String[] results = new String[count];
        //3
        int index = 0;
        int resIndex = 0;
        for (int balance : balances) {
            if (balance >= n) {
                results[resIndex] = cliens[index];
                resIndex++;
            }
            index++;
        }
        return results;
    }

    public static String[] findClientsWithNegativeByBalance(String[] cliens, int[] balances) {
        // String[] results = new String[cliens.length];


        // 1. знаходимо кількість результатів
        // 2. створюємо масив з довжиною результатів
        // 3. записуєм результати


        //1
        int count = 0;
        for (int balance : balances) {
            if (balance < 0)
                count++;


        }
        //2
        String[] results = new String[count];

        //3
        int index = 0;
        int resIndex = 0;
        for (int balance : balances) {
            if (balance < 0) {
                results[resIndex] = cliens[index];
                resIndex++;
            }
            index++;
        }
        return results;

    }

    static void depositMoney(String[] clients, int[] balances, String client, int money) {
        // 1. знайти клієнта в базі (в нашому випадку в масивах)
        // 2. зчитуємо сумупоповнення з врахуванням комісії
        // 3. оновлюємо баланс (поповнюємо)


        //1
        // int clientIndex = findClientIndexByName(clients, client);


        //2
        // int moneyToDeposit = calculateDepositAmountAfterComission(money);


        //3


        balances[findClientIndexByName(clients, client)] +=calculateDepositAmountAfterComission(money);
    }

    public static int findClientIndexByName(String[] clients, String client) {
        int clientIndex = 0;
        for (String cl : clients) {
            if (cl == client) {
                break;
            }
            clientIndex++;
        }
        return clientIndex;
    }
    static int calculateDepositAmountAfterComission(int money){
        return money <= 100 ? (int) (money - money * 0.02) : (int) (money - money * 0.01);

    }

    static int  withdraw(String[] clients, int[] balances, String client, int amount){
      return  balances[findClientIndexByName(clients, client)] >= amount ? balances[findClientIndexByName(clients, client)] - amount : -1;
    }
}



