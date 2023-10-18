import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SavingsTest {

    public static final String TYPE = "savings";
    public static final double APR = 0.05;

    Savings savings;

    @BeforeEach
    void setUp() {
        savings = new Savings(TYPE, APR);
    }

    @Test
    public void savings_account_is_of_correct_type() {
        assertEquals(TYPE, savings.getAccountType());
    }

    @Test
    public void savings_account_has_apr() {
        assertEquals(APR, savings.getAPR());
    }

    @Test
    public void initial_account_balance_is_zero() {
        assertEquals(0, savings.getBalance());
    }

}
