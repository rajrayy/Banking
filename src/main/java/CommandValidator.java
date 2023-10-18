import java.util.Arrays;
import java.util.List;

public class CommandValidator {

    protected Bank bank;
    CreateValidator createValidator;
    DepositValidator depositValidator;

    public CommandValidator(Bank bank) {
        this.bank = bank;
    }

    public List<String> parseCommand(String command) {
        return Arrays.asList(command.toLowerCase().split(" "));
    }

    public boolean validateCreate(List<String> command) {
        createValidator = new CreateValidator(bank);
        return createValidator.validate(command);
    }

    protected String getParameterValue(List<String> command, int i) {
        return String.valueOf(command.get(i));
    }
}
