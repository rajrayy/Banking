import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckingTest {

    public static final String TYPE = "checking";
    public static final double APR = 0.05;

    Checking checking;

    @BeforeEach
    void setUp() {
        checking = new Checking(TYPE, APR);
    }

    @Test
    public void checking_account_is_of_correct_type() {
        assertEquals(TYPE, checking.getAccountType());
    }

    @Test
    public void checking_account_has_apr() {
        assertEquals(APR, checking.getAPR());
    }

    @Test
    public void initial_account_balance_is_zero() {
        assertEquals(0, checking.getBalance());
    }

}
