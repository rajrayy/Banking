import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    public static final String ID = "12345678";
    public static final double APR = 0.75;
    public static final double BALANCE = 2000;
    public static final String SAVINGS_TYPE = "SAVINGS";
    public static final String CHECKING_TYPE = "CHECKING";
    public static final String CD_TYPE = "CD";

    Bank bank;
    Checking checking;
    Savings savings;
    CD cd;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        savings = new Savings(SAVINGS_TYPE, APR);
        checking = new Checking(CHECKING_TYPE, APR);
        cd = new CD(CD_TYPE, APR, BALANCE);
    }

    @Test
    void deposit_into_savings_account() {
        bank.addAccount(ID, savings);
        bank.deposit(ID, 1000);
        assertEquals(1000, bank.getAccounts().get(ID).getBalance());
    }

    @Test
    void deposit_decimal_amount_into_savings_account() {
        bank.addAccount(ID, savings);
        bank.deposit(ID, 3567.22);
        assertEquals(3567.22, bank.getAccounts().get(ID).getBalance());
    }

    @Test
    void deposit_twice_into_savings_account() {
        bank.addAccount(ID, savings);
        bank.deposit(ID, 6000.50);
        bank.deposit(ID, 2000);
        assertEquals(8000.50, bank.getAccounts().get(ID).getBalance());
    }

    @Test
    void deposit_into_checking_account() {
        bank.addAccount(ID, checking);
        bank.deposit(ID, 1000);
        assertEquals(1000, bank.getAccounts().get(ID).getBalance());
    }

    @Test
    void deposit_decimal_amount_into_checking_account() {
        bank.addAccount(ID, checking);
        bank.deposit(ID, 4987.65);
        assertEquals(4987.65, bank.getAccounts().get(ID).getBalance());
    }

    @Test
    void deposit_twice_into_checking_account() {
        bank.addAccount(ID, checking);
        bank.deposit(ID, 1000);
        bank.deposit(ID, 2000);
        assertEquals(3000, bank.getAccounts().get(ID).getBalance());
    }

    @Test
    void deposit_into_cd_account() {
        bank.addAccount(ID, cd);
        bank.deposit(ID, 1000);
        assertEquals(3000, bank.getAccounts().get(ID).getBalance());
    }

    @Test
    void deposit_decimal_amount_into_cd_account() {
        bank.addAccount(ID, cd);
        bank.deposit(ID, 9000.50);
        assertEquals(11000.50, bank.getAccounts().get(ID).getBalance());
    }

    @Test
    void deposit_twice_into_cd_account() {
        bank.addAccount(ID, cd);
        bank.deposit(ID, 1000);
        bank.deposit(ID, 2000);
        assertEquals(5000, bank.getAccounts().get(ID).getBalance());
    }

    @Test
    void withdraw_from_savings_account() {
        bank.addAccount(ID, savings);
        bank.deposit(ID, 1000);
        bank.withdraw(ID, 500);
        assertEquals(500, bank.getAccounts().get(ID).getBalance());
    }

    @Test
    void withdraw_decimal_amount_from_savings_account() {
        bank.addAccount(ID, savings);
        bank.deposit(ID, 3000.50);
        bank.withdraw(ID, 999.99);
        assertEquals(2000.51, bank.getAccounts().get(ID).getBalance());
    }

    @Test
    void withdraw_twice_from_savings_account() {
        bank.addAccount(ID, savings);
        bank.deposit(ID, 1000);
        bank.withdraw(ID, 200);
        bank.withdraw(ID, 300);
        assertEquals(500, bank.getAccounts().get(ID).getBalance());
    }

    @Test
    void withdraw_from_checking_account() {
        bank.addAccount(ID, checking);
        bank.deposit(ID, 1000);
        bank.withdraw(ID, 200);
        assertEquals(800, bank.getAccounts().get(ID).getBalance());
    }

    @Test
    void withdraw_decimal_amount_from_checking_account() {
        bank.addAccount(ID, checking);
        bank.deposit(ID, 9999.99);
        bank.withdraw(ID, 1000.01);
        assertEquals(8999.98, bank.getAccounts().get(ID).getBalance());
    }

    @Test
    void withdraw_twice_from_checking_account() {
        bank.addAccount(ID, checking);
        bank.deposit(ID, 1000);
        bank.withdraw(ID, 200);
        bank.withdraw(ID, 300);
        assertEquals(500, bank.getAccounts().get(ID).getBalance());
    }

    @Test
    void withdraw_from_cd_account() {
        bank.addAccount(ID, cd);
        bank.deposit(ID, 2000);
        bank.withdraw(ID, 1000);
        assertEquals(3000, bank.getAccounts().get(ID).getBalance());
    }

    @Test
    void withdraw_decimal_amount_from_cd_account() {
        bank.addAccount(ID, cd);
        bank.deposit(ID, 2000);
        bank.withdraw(ID, 100.01);
        assertEquals(3899.99, bank.getAccounts().get(ID).getBalance());
    }

    @Test
    void withdraw_twice_from_cd_account() {
        bank.addAccount(ID, cd);
        bank.withdraw(ID, 500);
        bank.withdraw(ID, 700);
        assertEquals(800, bank.getAccounts().get(ID).getBalance());
    }

    @Test
    void withdraw_entire_balance_from_savings() {
        bank.addAccount(ID, savings);
        bank.deposit(ID, 1000);
        bank.withdraw(ID, 1000);
        assertEquals(0, bank.getAccounts().get(ID).getBalance());
    }

    @Test
    void withdraw_entire_balance_from_checking() {
        bank.addAccount(ID, checking);
        bank.deposit(ID, 1000);
        bank.withdraw(ID, 1000);
        assertEquals(0, bank.getAccounts().get(ID).getBalance());
    }

    @Test
    void withdraw_entire_balance_from_cd() {
        bank.addAccount(ID, cd);
        bank.deposit(ID, 500);
        bank.withdraw(ID, 2500);
        assertEquals(0, bank.getAccounts().get(ID).getBalance());
    }

    @Test
    void withdraw_more_than_balance_from_savings() {
        bank.addAccount(ID, savings);
        bank.deposit(ID, 1000);
        bank.withdraw(ID, 3000);
        assertEquals(0, bank.getAccounts().get(ID).getBalance());
    }

    @Test
    void withdraw_more_than_balance_from_checking() {
        bank.addAccount(ID, checking);
        bank.deposit(ID, 1000);
        bank.withdraw(ID, 3000);
        assertEquals(0, bank.getAccounts().get(ID).getBalance());
    }

    @Test
    void withdraw_more_than_balance_from_cd() {
        bank.addAccount(ID, savings);
        bank.withdraw(ID, 3000);
        assertEquals(0, bank.getAccounts().get(ID).getBalance());
    }

}
