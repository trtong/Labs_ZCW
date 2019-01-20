package rocks.zipcode.atm.bank;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import rocks.zipcode.atm.ActionResult;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author ZipCodeWilmington
 */
public class Bank {

    private Map<Integer, Account> accounts = new HashMap<>();
    private Map<Integer, String> passwords = new HashMap<>();

    StringBuilder transactions = new StringBuilder();

    public Bank() {
        accounts.put(1000, new BasicAccount(new AccountData(
                1000, "Jared Walrus", "fisher@abe.com", 500
        )));

        accounts.put(2000, new PremiumAccount(new AccountData(
                2000, "Biggie Younger", "southerKingdom@fisher.com", 200
        )));

        accounts.put(3000, new PremiumAccount(new AccountData(
                3000, "Usurper TeeTay", "westernUnion@bank.com", 100
        )));

        for (Integer account: accounts.keySet()) {
            passwords.put(account, "1234");
        }
    }

    public Set<Integer> allAccounts() {
        return passwords.keySet();
    }

    public boolean accountExists(Integer id) {
        boolean hasAccount = false;

        for (Integer key: allAccounts()) {
            if (key.equals(id)) {
                hasAccount = true;
                break;
            }
        }

        return hasAccount;
    }

    public boolean checkPassword(int id, String password) {
        boolean correctPassword =  true;

        if (!password.equals(passwords.get(id))) {
            correctPassword = false;
        }

        return correctPassword;
    }

//    public void changePW(int id, String pw) {
//        passwords.put(id, pw);
//    }

    public ActionResult<AccountData> getAccountById(int id) {
        Account account = accounts.get(id);

        if (account != null) {
            return ActionResult.success(account.getAccountData());
        } else {
            return ActionResult.fail("No account with id: " + id + "\nTry account 1000 or 2000");
        }
    }

    public ActionResult<AccountData> deposit(AccountData accountData, float amount) {
        Account account = accounts.get(accountData.getId());
        account.deposit(amount);


        transactions.append(String.format("User deposited $%.2f.\n", amount));

        return ActionResult.success(account.getAccountData());
    }

    public ActionResult<AccountData> withdraw(AccountData accountData, float amount) {
        // this gets the ID from account data and then gets the account in the hashmap
        Account account = accounts.get(accountData.getId());
        boolean ok = account.withdraw(amount);

        if (ok) {

            if (account.getBalance() < 0) {

                Alert overDraftAlert = new Alert(Alert.AlertType.INFORMATION);
                overDraftAlert.setContentText("This transaction will overdraft your account.");
                overDraftAlert.showAndWait();
                transactions.append(String.format("User overdrafted account to $%.2f\n", account.getBalance()));
                return ActionResult.success(account.getAccountData());

            } else {
                transactions.append(String.format("User withdrew $%.2f.\n", amount));

                return ActionResult.success(account.getAccountData());
            }


        } else {

            transactions.append(String.format("Withdraw failed: %.2f +. Account has: %.2f.\n", amount, account.getBalance()));
            return ActionResult.fail("See transactions.");

        }
    }

    public String transactionString () {
        return transactions.toString();
    }

}
