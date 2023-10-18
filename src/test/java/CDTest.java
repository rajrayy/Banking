import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CDTest {

    public static final String TYPE = "CD";
    public static final double APR = 0.05;
    public static final double BALANCE = 2000;

    CD cd;

    @BeforeEach
    void setUp() {
        cd = new CD(TYPE, APR, BALANCE);
    }

    @Test
    public void cd_account_is_of_correct_type() {
        assertEquals(TYPE, cd.getAccountType());
    }

    @Test
    public void cd_account_has_apr() {
        assertEquals(APR, cd.getAPR());
    }

    @Test
    public void cd_account_has_balance() {
        assertEquals(2000, cd.getBalance());
    }

}
