package lesson12;

public class UkrainianBankSystem implements BankSystem {
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


        //double balanceAfterWithdraw = user.getBalance() - amount - user.getBank().getCommission(amount);
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));

    }


    @Override
    public void fund(User user, int amount) {
        if (!checkLimitsOfFunding(user, amount))
            return;
        user.setBalance(user.getBalance() + amount);

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


    }

    @Override
    public void paySalary(User user) {

        if (!checkLimitsOfFunding(user, user.getSalary()))
            return;
        user.setBalance(user.getBalance() + user.getSalary());

    }

    private boolean checkWithdraw(User user, int amount) {
        return checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) && checkWithdrawLimits(user, amount, user.getBalance());
    }

    private boolean checkWithdrawLimits(User user, int amount, double limit) {
        if (amount + user.getBank().getCommission(amount) > limit) {
            printWithdrawErrorMsg(amount, user);
            return false;
        }
        return true;


    }

    private boolean checkLimitsOfFunding(User user, int amount) {
        if (amount > user.getBank().getLimitOfFunding()) {
            printWithdrawErrorMsg(amount, user);
            return false;
        }
        return true;


    }

    public boolean checkCurrency(User fromUser, User toUser) {
        return fromUser.getBank().getCurrency() == toUser.getBank().getCurrency();


    }


    private void printWithdrawErrorMsg(int amount, User user) {
        System.err.println("Can't withdraw money " + amount + " from user " + user.toString());
    }


}
