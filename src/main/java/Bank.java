import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<String, Account> accounts;

    Bank() {
        accounts = new HashMap<>();
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void addAccount(String id, Account account) {
        accounts.put(id, account);
    }

    public void deposit(String id, double amount) {
        accounts.get(id).deposit(amount);
    }

    public void withdraw(String id, double amount) {
        accounts.get(id).withdraw(amount);
    }
}
