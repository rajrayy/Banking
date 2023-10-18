public class DepositValidator extends CommandValidator {
    private String id;
    private String balance;

    public DepositValidator(Bank bank) {
        super(bank);
    }
}
