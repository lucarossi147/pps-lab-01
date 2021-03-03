package lab01.example.model;

public interface BankAccountWithAtm extends BankAccount{

    /**
     * Allows the deposit of an amount on the account from an ATM, if the given usrID corresponds to the register holder
     * ID of the bank account. This ID acts like an "identification token" .
     * With this method you have to pay a fee
     *
     * @param usrID the id of the user that wants do the deposit
     * @param amount the amount of the deposit
     */
    void depositWithAtm(int usrID, double amount);

    /**
     * Allows the withdraw of an amount from the account from an ATM, if the given usrID corresponds to the register
     * holder ID of the bank account. This ID acts like an "identification token" .
     * With this method you have to pay a fee
     * @param usrID the id of the user that wants do the withdraw
     * @param amount the amount of the withdraw
     */
    void withdrawFromAtm(int usrID, double amount);

    double getATM_FEES();
}
