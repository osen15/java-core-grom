package lesson5;


public class WithDrawHomeWork {
    public static void main(String[] args) {
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, -99, 1200, -54, 0};
        System.out.println(withdraw(names, balances, "Ann", 50));
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
    static int  withdraw(String[] clients, int[] balances, String client, int amount){
        return  balances[findClientIndexByName(clients, client)] >= amount ? balances[findClientIndexByName(clients, client)] - amount : -1;
    }


}