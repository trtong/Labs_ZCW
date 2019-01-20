import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class AcctService{

    private Dao<Account, Integer> dao;
    private Console c = new Console();

    public AcctService(Dao<Account, Integer> dao) {
        this.dao = dao;
    }

    public int create(Account account) throws Exception {
        return dao.create(account);
    }

    public List<Account> read() throws Exception {
        return dao.queryForAll();
    }

    public String updateInputString() {
        String updateInput = c.printAndStrInput("1: Update Name\n"
                + "2: Update Password\n"
                + "Select by number (any other number to return to Main Menu): ");

        return updateInput;
    }

    public int askForId() {
        int requestedID = c.printAndNextInt("What is the ID you want to update?");
        return requestedID;
    }

    public void updateMenu(Account acc, String s) throws SQLException {

        if (s.equals("1")){
            String newName = c.printAndStrInput("What is the new name: ");
            updateName(acc, newName);

        } else if (s.equals("2")) {
            String newPw = c.printAndStrInput("What is the new password: ");
            updatePassword(acc, newPw);

        } else {
            c.print("Returning to menu...\n");
        }
    }

    public int destroy(Account a) throws SQLException {
        return dao.delete(a);
    }

    public void readAllAccounts(List<Account> moo) {
        c.readHeader();
        for (Account a : moo) {
            c.printFormatRead(a.getId(), a.getName(), a.getPassword());
        }
    }

    public Account createNewAccount(){
        String name = c.printAndStrInput("Enter the name for the account: ");
        String pw = c.printAndStrInput("Enter the password for the account: ");

        Account account = new Account(name);
        account.setPassword(pw);
        return account;
    }

    public void updatePassword(Account acc, String pw) throws SQLException{
        acc.setPassword(pw);
        dao.update(acc);
    }

    public void updateName(Account acc, String name) throws SQLException {
        acc.setName(name);
        dao.update(acc);
    }

    public int menuDestroy() throws SQLException{
        int destroyID = c.printAndNextInt("Enter the id you want to destroy: ");
        if (getById(destroyID) != null) {
            return destroyID;
        }
        return -1;
    }

    public Account getById(int id) throws SQLException {
        return dao.queryForId(id);
    }

    public void fullUpdateMenu() throws Exception {
        readAllAccounts(read());
        String option = updateInputString();
        int requestedID = askForId();
        updateMenu(getById(requestedID), option);
    }

    public void fullDeleteMenu() throws Exception {
        readAllAccounts(read());
        int destroyMe = menuDestroy();
        destroy(getById(destroyMe));

    }
}
