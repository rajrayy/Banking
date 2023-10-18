import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandValidatorTest {

    public static final String ID = "12345678";
    public static final double APR = 0.75;
    public static final double BALANCE = 2000;
    public static final String SAVINGS_TYPE = "SAVINGS";
    public static final String CHECKING_TYPE = "CHECKING";
    public static final String CD_TYPE = "CD";
    String command;

    Bank bank;
    Account savings;
    Account checking;
    Account cd;
    CommandValidator commandValidator;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        savings = new Savings(SAVINGS_TYPE, APR);
        checking = new Checking(CHECKING_TYPE, APR);
        cd = new CD(CD_TYPE, APR, BALANCE);
        commandValidator = new CommandValidator(bank);
    }

    @Test
    void null_input_parses_correctly() {
        command = " ";
        List<String> actual = commandValidator.parseCommand(command);
        assertEquals(actual, Arrays.asList());
    }

    @Test
    void create_savings_command_parses_correctly_into_a_list() {
        command = "create savings 12345678 2.5";
        List<String> actual = commandValidator.parseCommand(command);
        assertEquals(actual, Arrays.asList("create", "savings", "12345678", "2.5"));
    }

    @Test
    void create_checking_command_parses_correctly_into_a_list() {
        command = "create checking 12345678 2.5";
        List<String> actual = commandValidator.parseCommand(command);
        assertEquals(actual, Arrays.asList("create", "checking", "12345678", "2.5"));
    }

    @Test
    void create_cd_command_parses_correctly_into_a_list() {
        command = "create cd 12345678 2.5 5000";
        List<String> actual = commandValidator.parseCommand(command);
        assertEquals(actual, Arrays.asList("create", "cd", "12345678", "2.5", "5000"));
    }

    @Test
    void valid_create_command_with_mixed_case_parses_correctly() {
        command = "CrEaTe cD 12345678 2.5 10000";
        List<String> actual = commandValidator.parseCommand(command);
        assertEquals(actual, Arrays.asList("create", "cd", "12345678", "2.5", "10000"));
    }

    @Test
    void invalid_create_command_with_whitespaces_parses_correctly() {
        command = " create   savings   12345678   3.5 ";
        List<String> actual = commandValidator.parseCommand(command);
        assertEquals(actual, Arrays.asList("", "create", "", "", "savings", "", "", "12345678", "", "", "3.5"));
    }

    @Test
    void invalid_create_command_with_jumbled_syntax_parses_correctly() {
        command = "12345678 create 2.5 cd 3000";
        List<String> actual = commandValidator.parseCommand(command);
        assertEquals(actual, Arrays.asList("12345678", "create", "2.5", "cd", "3000"));
    }

    @Test
    void valid_deposit_command_parses_correctly() {
        command = "deposit 12345678 2000";
        List<String> actual = commandValidator.parseCommand(command);
        assertEquals(actual, Arrays.asList("deposit", "12345678", "2000"));
    }

    @Test
    void invalid_deposit_command_parses_correctly() {
        command = "depo 1500 12345678";
        List<String> actual = commandValidator.parseCommand(command);
        assertEquals(actual, Arrays.asList("depo", "1500", "12345678"));
    }

    @Test
    void valid_deposit_command_with_mixed_case_parses_correctly() {
        command = "dEpoSIt 12345678 1200";
        List<String> actual = commandValidator.parseCommand(command);
        assertEquals(actual, Arrays.asList("deposit", "12345678", "1200"));
    }

    @Test
    void validate_valid_create_savings_command() {
        List<String> savings = Arrays.asList("create", "savings", "12345678", "2.5");
        boolean actual = commandValidator.validateCreate(savings);
        assertTrue(actual);
    }

}
