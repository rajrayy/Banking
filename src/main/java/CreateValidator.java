import java.util.List;

public class CreateValidator extends CommandValidator {
    private String id;
    private String balance;
    private String apr;
    private String accountType;

    public CreateValidator(Bank bank) {
        super(bank);
    }

    public String getID() {
        return this.id;
    }

    public String getBalance() {
        return this.balance;
    }

    public String getAPR() {
        return this.apr;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public boolean validate(List<String> command) {
        try {
            defineVariables(command);
            return validateCommandLength(command, getAccountType());
        } catch (ArrayIndexOutOfBoundsException exception) {
            return false;
        }
    }

    public boolean validateCommandLength(List<String> command, String accountType) {
        if (accountType.equals("savings") || accountType.equals("checking")) {
            return (command.size() == 4);
        } else if (accountType.equals("cd")) {
            return (command.size() == 5);
        } else {
            return false;
        }
    }

    public void defineVariables(List<String> command) {
        this.accountType = getParameterValue(command, 1);
        this.id = getParameterValue(command, 2);
        this.apr = getParameterValue(command, 3);
        if (accountType.equals("savings") || accountType.equals("checking")) {
            this.balance = getParameterValue(command, 4);
        } else {
            this.balance = "0";
        }
    }


}
