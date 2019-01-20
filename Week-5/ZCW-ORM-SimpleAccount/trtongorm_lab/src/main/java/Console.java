import java.util.Scanner;

public class Console {

    Scanner in;

    public Console(Scanner in) {
        this.in = in;
    }

    public Console() {
        in = new Scanner(System.in);
    }

    public String printAndStrInput(String s) {
        System.out.println(s);
        return in.next();
    }

    public void printFormatRead(int id, String name, String pw) {
        System.out.println(String.format("|%11s| |%15s| |%15s|", id, name, pw));
    }

    public void readHeader() {
        System.out.println("Displaying all accounts:\n");
        System.out.println(String.format("|%11s| |%15s| |%15s|", "ID", "NAME", "PASSWORD"));
        System.out.println("_________________________________________________");
    }

    public int nextInt() {
        return in.nextInt();
    }

    public int printAndNextInt(String s) {
        System.out.println(s);
        return in.nextInt();
    }

    public void print(String s) {
        System.out.println(s);
    }

    public void printMenu() {
        System.out.println("Menu Options:\n"
                + "1: Create - Create a new account\n"
                + "2: Read - Lists all accounts in database\n"
                + "3: Update - Update an existing account\n"
                + "4: Delete - Deletes an existing account\n"
                + "5: Quit Account Database Manager\n");
    }
}
