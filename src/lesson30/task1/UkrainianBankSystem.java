package lesson30.task1;

import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class UkrainianBankSystem implements BankSystem {
    private Set<Transaction> transactions = new TreeSet<>();




    @Override
    public void withdraw(User user, int amount) {
        //  перевірити чи можна зняти - перевірити ліміт, перевірити чи достатньо грошей
        //  зняти гроші
        //  int limitOfWithdrawl = user.getBank().getLimitOfWithdrawal();
        //if (amount + user.getBank().getCommission(amount) > limitOfWithdrawl) {
        //  printWithdrawErrorMsg(amount, user);
        //return;

        //}
        //if (amount + user.getBank().getCommission(amount) > user.getBalance()) {
        //  printWithdrawErrorMsg(amount, user);
        //return;


        // }
        if (!checkWithdraw(user, amount))
            return;


        if (amount >= 0)
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));

       createAndSaveTransaction(new Date(),TransactionType.WITHDRAWAL, amount, "sdsdc");


    }


    @Override
    public void fund(User user, int amount) {

        if (!checkLimitsOfFunding(user, amount))
            return;

        user.setBalance(user.getBalance() + amount);
        createAndSaveTransaction(new Date(),TransactionType.FUNDING, amount, "sdsdc");



    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        if (!checkCurrency(fromUser, toUser))
            return;
        if (!checkWithdraw(fromUser, amount))
            return;
        fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount));
        if (!checkLimitsOfFunding(toUser, amount))
            return;
        toUser.setBalance(toUser.getBalance() + amount);
        createAndSaveTransaction(new Date(),TransactionType.TRANSFER, amount, "sdsdc");

    }

    @Override
    public void paySalary(User user, int amount) {
         if (userNotNull(user) != true)
             return;
        if (!checkLimitsOfFunding(user, user.getSalary()))
             return;
        user.setBalance(user.getBalance() + user.getSalary());
        createAndSaveTransaction(new Date(),TransactionType.SALARY_INC, amount, "sdsdc");


    }

    private boolean checkWithdraw(User user, int amount) {

        return userNotNull(user)  &&  checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) && checkWithdrawLimits(user, amount, user.getBalance());


    }


    private boolean checkWithdrawLimits(User user, int amount, double limit) {
        if (amount + user.getBank().getCommission(amount) > limit) {
            printWithdrawErrorMsg(amount, user);
            return false;
        }
        return true;


    }

    private boolean checkLimitsOfFunding(User user, int amount) {
        if (userNotNull(user) == false)
            return  false;
        if (amount > user.getBank().getLimitOfFunding())
            return false;

        return true;


    }

    private boolean checkCurrency(User fromUser, User toUser) {
        if (userNotNull(fromUser) == false || userNotNull(toUser) == false)
            return false;
        return fromUser.getBank().getCurrency() == toUser.getBank().getCurrency();


    }

    private boolean userNotNull(User user){
        return user == null ? false : true;
    }

    private void printWithdrawErrorMsg(int amount, User user) {
        System.err.println("Can't withdraw money " + amount + " from user " + user.toString());
    }
    private Transaction createAndSaveTransaction(Date dateCreated, TransactionType type, int amount, String descr){
        Random random = new Random();
        Transaction tr = new Transaction(random.nextInt(), dateCreated, null, type, amount, descr);
        transactions.add(tr);
        return tr;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }
}
