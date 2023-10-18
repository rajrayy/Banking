import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BankTest {

    public static final String ID = "12345678";
    public static final double APR = 0.75;
    public static final double BALANCE = 2000;
    public static final String SAVINGS_TYPE = "SAVINGS";
    public static final String CHECKING_TYPE = "CHECKING";
    public static final String CD_TYPE = "CD";

    Bank bank;
    Savings savings;
    Checking checking;
    CD cd;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        savings = new Savings(SAVINGS_TYPE, APR);
        checking = new Checking(CHECKING_TYPE, APR);
        cd = new CD(CD_TYPE, APR, BALANCE);
    }

    @Test
    void bank_has_no_accounts_initially() {
        assertTrue(bank.getAccounts().isEmpty());
    }

    @Test
    void add_savings_account_to_bank() {
        bank.addAccount(ID, savings);
        assertEquals(savings, bank.getAccounts().get(ID));
    }

    @Test
    void savings_account_retrieved_has_correct_id() {
        bank.addAccount(ID, savings);
        assertTrue(bank.getAccounts().containsKey(ID));
    }

    @Test
    void savings_account_retrieved_has_correct_type() {
        bank.addAccount(ID, savings);
        assertEquals(SAVINGS_TYPE, bank.getAccounts().get(ID).getAccountType());
    }

    @Test
    void savings_account_retrieved_has_correct_apr() {
        bank.addAccount(ID, savings);
        assertEquals(APR, bank.getAccounts().get(ID).getAPR());
    }

    @Test
    void savings_account_retrieved_has_correct_balance() {
        bank.addAccount(ID, savings);
        assertEquals(0, bank.getAccounts().get(ID).getBalance());
    }

    @Test
    void add_two_savings_accounts_to_bank() {
        Savings savingsAccountTwo = new Savings(SAVINGS_TYPE, 0.05);

        bank.addAccount(ID, savings);
        bank.addAccount("23456789", savingsAccountTwo);
        assertEquals(savings, bank.getAccounts().get(ID));
        assertEquals(savingsAccountTwo, bank.getAccounts().get("23456789"));
    }

    @Test
    void two_savings_accounts_are_correctly_saved_in_bank() {
        bank.addAccount(ID, savings);
        bank.addAccount("23456789", savings);
        assertEquals(2, bank.getAccounts().size());
    }

    @Test
    void add_checking_account_to_bank() {
        bank.addAccount(ID, checking);
        assertEquals(checking, bank.getAccounts().get(ID));
    }

    @Test
    void checking_account_retrieved_has_correct_id() {
        bank.addAccount(ID, checking);
        assertTrue(bank.getAccounts().containsKey(ID));
    }

    @Test
    void checking_account_retrieved_has_correct_type() {
        bank.addAccount(ID, checking);
        assertEquals(CHECKING_TYPE, bank.getAccounts().get(ID).getAccountType());
    }

    @Test
    void checking_account_retrieved_has_correct_apr() {
        bank.addAccount(ID, checking);
        assertEquals(APR, bank.getAccounts().get(ID).getAPR());
    }

    @Test
    void checking_account_retrieved_has_correct_balance() {
        bank.addAccount(ID, checking);
        assertEquals(0, bank.getAccounts().get(ID).getBalance());
    }

    @Test
    void add_two_checking_accounts_to_bank() {
        Checking checkingAccountTwo = new Checking(CHECKING_TYPE, 0.05);
        bank.addAccount(ID, checking);
        bank.addAccount("23456789", checkingAccountTwo);
        assertEquals(checking, bank.getAccounts().get(ID));
        assertEquals(checkingAccountTwo, bank.getAccounts().get("23456789"));
    }

    @Test
    void check_if_two_checking_accounts_are_correctly_saved_in_bank() {
        bank.addAccount(ID, checking);
        bank.addAccount("23456789", checking);
        assertEquals(2, bank.getAccounts().size());
    }

    @Test
    void add_cd_account_to_bank() {
        bank.addAccount(ID, cd);
        assertEquals(cd, bank.getAccounts().get(ID));
    }

    @Test
    void cd_account_retrieved_has_correct_id() {
        bank.addAccount(ID, cd);
        assertTrue(bank.getAccounts().containsKey(ID));
    }

    @Test
    void cd_account_retrieved_has_correct_type() {
        bank.addAccount(ID, cd);
        assertEquals(CD_TYPE, bank.getAccounts().get(ID).getAccountType());
    }

    @Test
    void cd_account_retrieved_has_correct_apr() {
        bank.addAccount(ID, cd);
        assertEquals(APR, bank.getAccounts().get(ID).getAPR());
    }

    @Test
    void cd_account_retrieved_has_correct_balance() {
        bank.addAccount(ID, cd);
        assertEquals(2000, bank.getAccounts().get(ID).getBalance());
    }

    @Test
    void add_two_cd_accounts_to_bank() {
        CD cdAccountTwo = new CD(CD_TYPE, 0.05, 1500);
        bank.addAccount(ID, cd);
        bank.addAccount("23456789", cdAccountTwo);
        assertEquals(cd, bank.getAccounts().get(ID));
        assertEquals(cdAccountTwo, bank.getAccounts().get("23456789"));
    }

    @Test
    void check_if_two_cd_accounts_are_correctly_saved_in_bank() {
        bank.addAccount(ID, cd);
        bank.addAccount("23456789", cd);
        assertEquals(2, bank.getAccounts().size());
    }

    @Test
    void add_savings_and_checking_accounts_to_bank() {
        bank.addAccount(ID, savings);
        bank.addAccount("23456789", checking);
        assertEquals(savings, bank.getAccounts().get(ID));
        assertEquals(checking, bank.getAccounts().get("23456789"));
    }

    @Test
    void add_savings_and_cd_accounts_to_bank() {
        bank.addAccount(ID, savings);
        bank.addAccount("23456789", cd);
        assertEquals(savings, bank.getAccounts().get(ID));
        assertEquals(cd, bank.getAccounts().get("23456789"));
    }

    @Test
    void add_checking_and_cd_accounts_to_bank() {
        bank.addAccount(ID, checking);
        bank.addAccount("23456789", cd);
        assertEquals(checking, bank.getAccounts().get(ID));
        assertEquals(cd, bank.getAccounts().get("23456789"));
    }

    @Test
    void add_multiple_accounts_to_bank() {
        bank.addAccount(ID, savings);
        bank.addAccount("23456789", savings);
        bank.addAccount("34567890", checking);
        bank.addAccount("45678901", cd);
        bank.addAccount("56789012", checking);
        assertEquals(5, bank.getAccounts().size());
    }
}

