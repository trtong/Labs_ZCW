package rocks.zipcode.atm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import rocks.zipcode.atm.bank.AccountData;
import rocks.zipcode.atm.bank.Bank;

import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author ZipCodeWilmington
 */
public class CashMachine {

    private final Bank bank;
    private AccountData accountData = null;

    public CashMachine(Bank bank) {

        this.bank = bank;
    }

    private Consumer<AccountData> update = data -> {
        accountData = data;
    };

    public boolean checkUserId (int id) {
       return bank.accountExists(id);
    }

    public boolean comparePassword (int id, String pw) {
        return bank.checkPassword(id, pw);
    }

//    public void changePw(int id, String pw) {
//        tryCall(
//                () -> bank.changePW(id, pw),
//                update
//        );
//    }

    public void login(int id) {
        tryCall(
                () -> bank.getAccountById(id),
                update
        );
    }

    public void deposit(float amount) {
        if (accountData != null) {
            tryCall(
                    () -> bank.deposit(accountData, amount),
                    update
            );

        }
    }

    public void withdraw(float amount) {
        if (accountData != null) {
            tryCall(
                    () -> bank.withdraw(accountData, amount),
                    update
            );

            // Over draft check for alert message?

        }
    }

    public void exit() {
        if (accountData != null) {
            // exiting account -> for this we want to clear display account summary of transactions and then clear all fields
            accountData = null;
        }
    }

    public Set<Integer> accountSet() {
        return bank.allAccounts();
    }

    public String transactionString() {
        return bank.transactionString();
    }

    @Override
    public String toString() {
        return accountData != null ? accountData.toString() : "Bye!";
    }



    private <T> void tryCall(Supplier<ActionResult<T> > action, Consumer<T> postAction) {
        try {
            ActionResult<T> result = action.get();
            if (result.isSuccess()) {
                T data = result.getData();
                postAction.accept(data);
            } else {
                String errorMessage = result.getErrorMessage();
                // Create alert here, rather than throwing an exception

                throw new RuntimeException(errorMessage);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void setPassword(int id) {

    }
}
