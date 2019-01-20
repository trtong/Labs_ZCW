
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;


public class AccountApp {

    private Dao<Account, Integer> a;

    private void setupDao(ConnectionSource connectionSource) throws Exception {
        a = DaoManager.createDao(connectionSource, Account.class);
    }

    // we are using a MySQl database
    private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/orm_lab?useUnicode=true";
    private Console c = new Console();

    public static void main(String[] args) throws Exception {

        new AccountApp().doMain(args);
    }

    private void doMain(String[] args) throws Exception {
        ConnectionSource connectionSource = null;
        try {
            // create our data-source for the database
            connectionSource = new JdbcConnectionSource(DATABASE_URL, "root", "");
            setupDao(connectionSource);

            processData();

        } finally {

            c.print("Good Bye!");
            if (connectionSource != null) {
                connectionSource.close();
            }
        }
    }

    private void processData() throws Exception {

        AcctService acctService = new AcctService(a);

        boolean continueMenu =  true;
        System.out.println("Welcome to the account database manager!\n");

        while (continueMenu) {
            c.printMenu();
            String input = c.printAndStrInput("Select by the number: ");
            if (input.equals("1")) {
                Account createAcc = acctService.createNewAccount();
                acctService.create(createAcc);

            } else if (input.equals("2")) {
                acctService.readAllAccounts(acctService.read());

            } else if (input.equals("3")) {
                acctService.fullUpdateMenu();

            } else if (input.equals("4")) {
                acctService.fullDeleteMenu();
            } else {
                continueMenu = false;
            }
        }
    }
}
