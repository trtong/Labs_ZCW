package rocks.zipcode.atm.bank;

/**
 * @author ZipCodeWilmington
 */
public abstract class Account {

    private AccountData accountData;

    public Account(AccountData accountData) {

        this.accountData = accountData;
    }

    public AccountData getAccountData() {

        return accountData;
    }

    public void deposit(float amount) {
        if (positiveDollars(amount)) {
            updateBalance(getBalance() + amount);
        } else {
            // do nothing?
            // return an error message
        }
    }

    public boolean withdraw(float amount) {

        if (positiveDollars(amount)) {
            if (canWithdraw(amount)) {
                updateBalance(getBalance() - amount);
                return true;
            } else {
                return false;
            }
        }

        return false;
    }


    protected boolean canWithdraw(float amount) {

        return getBalance() >= amount;
    }

    public float getBalance() {

        return accountData.getBalance();
    }

    private void updateBalance(float newBalance) {
        accountData = new AccountData(accountData.getId(), accountData.getName(), accountData.getEmail(),
                newBalance);
    }

    public boolean positiveDollars(float amount) {
        if (amount > 0) {
            return true;
        } else {
            return false;
        }
    }
}
