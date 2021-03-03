package lab01.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleBankAccountWithAtmTest extends SimpleBankAccountTest{

    private AccountHolder accountHolder;
    private BankAccountWithAtm bankAccount;

    @Override
    @BeforeEach
    void beforeEach(){
        super.beforeEach();
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Test
    void testDepositWithAtm(){
        bankAccount.depositWithAtm(accountHolder.getId(), 100);
        assertEquals(99, bankAccount.getBalance());
    }

    @Test
    void testWrongDepositWithAtm() {
        bankAccount.depositWithAtm(accountHolder.getId(), 100);
        bankAccount.depositWithAtm(2, 50);
        assertEquals(100-bankAccount.getATM_FEES(), bankAccount.getBalance());
    }

    @Test
    void testWithdrawFromAtm() {
        bankAccount.depositWithAtm(accountHolder.getId(), 100);
        bankAccount.withdrawFromAtm(accountHolder.getId(), 70);
        assertEquals(30 - bankAccount.getATM_FEES() - bankAccount.getATM_FEES(), bankAccount.getBalance());
    }

    @Test
    void testWrongWithdrawFromAtm() {
        bankAccount.depositWithAtm(accountHolder.getId(), 100);
        bankAccount.withdrawFromAtm(2, 70);
        assertEquals(100 - bankAccount.getATM_FEES(), bankAccount.getBalance());
    }
}