public class Account<T extends AccountBook> {

    private T accountBook;
    private Payee owner;
    private double balance;

    public Account(T book) {
        accountBook = book;
        balance = book.getAmount();
    }

    public Account(T book, Payee owner) {
        accountBook = book;
        this.owner = owner;
        this.balance = book.getAmount();
    }

    public Payee getOwner() {
        return owner;
    }

    public void setOwner(Payee owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }
}