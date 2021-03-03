package lab01.example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount implements BankAccountWithAtm {

    private final double ATM_FEES = 1;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    public void depositWithAtm(int usrID, double amount) {
        if (checkUser(usrID)) {
            setBalance(amount - ATM_FEES);
        }
    }

    @Override
    public void withdrawFromAtm(int usrID, double amount) {
        if (checkUser(usrID) && isWithdrawFromAtmAllowed(amount)){
            setBalance(getBalance() - amount - ATM_FEES);
        }
    }

    public double getATM_FEES() {
        return ATM_FEES;
    }

    private boolean isWithdrawFromAtmAllowed(final double amount){
        return getBalance() - ATM_FEES >= amount;
    }
}
