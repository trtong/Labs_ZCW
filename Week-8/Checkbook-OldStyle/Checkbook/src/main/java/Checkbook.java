
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicReference;

public class Checkbook implements AccountBook {
    private final AtomicReference<Integer> id = new AtomicReference<>(ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE));
    private final AtomicReference<LocalDate> date = new AtomicReference<>(LocalDate.now());
    private Payee owner;
    private double amount;
    // Checkbook is a list of Transactions

    private List<Transaction> checkbook;
    private String memo;


    public Checkbook() {
        checkbook = new ArrayList<>();
    }

    public Checkbook(Transaction ... t) {
        this.checkbook = new ArrayList<>(Arrays.asList(t));
        accumulateAmount();

    }

    public Checkbook(double cashAmount) {
        this();
        this.amount = cashAmount;
    }

    public Checkbook(Payee owner, double cashAmount) {
        this();
        this.owner = owner;
        this.amount = cashAmount;
    }

    //blind us with your Java eloquence....
    void accumulateAmount() {
        if (!checkbook.isEmpty()) {
            for (Transaction t: checkbook
                 ) {
                amount += t.getAmount();
            }
        }
    }

    int size() {
        return this.checkbook.size();
    }

    boolean isEmpty() {
        return this.checkbook.isEmpty();
    }

    boolean contains(Transaction transaction) {
        return this.checkbook.contains(transaction);
    }

    boolean add(Transaction transaction) {
        amount += transaction.getAmount();
        return this.checkbook.add(transaction);
    }

    boolean remove(Transaction transaction) {
        amount -= transaction.getAmount();
        return this.checkbook.remove(transaction);
    }

    Iterator<Transaction> iterator() {
        return this.checkbook.iterator();
    }

    Transaction[] toArray() {
        return checkbook.toArray(new Transaction[checkbook.size()]);
    }

    Transaction[] toArray(Transaction[] a) {
        return this.checkbook.toArray(a);
    }

    Transaction[] toArrayFromList(List<Transaction> list) {
        return list.toArray(new Transaction[list.size()]);
    }

    double checkbookValue() {
        return this.amount;
    }

    List<Transaction> getCheckbook() {
        return checkbook;
    }

    boolean containsAll(Collection<Transaction> c) {
        return checkbook.containsAll(c);
    }

    boolean addAll(Collection<Transaction> c) {
        return checkbook.addAll(c);
    }

    boolean removeAll(Collection<Transaction> c) {
        return checkbook.removeAll(c);
    }

    void clear() {
        checkbook.clear();
    }

     Transaction[] getAllTransactionsForDate(LocalDate a) {
        return getSpecificTransactions("date", a);
    }

    Transaction[] getAllTransactionsForPayee(Payee a) {
        return getSpecificTransactions("payee", a);
    }

    Transaction[] getAllDebitTransactions() {
        return getSpecificTransactions("typee", TransactionType.DEBIT);
    }

    Transaction[] getAllCreditTransactions() {
        return getSpecificTransactions("typee", TransactionType.CREDIT);
    }

    private Transaction[] getSpecificTransactions(String fieldName, Object value) {

        List<Transaction> arr = new ArrayList<>();
        for (Transaction ts : this.checkbook) {
            Object valueToCheck = getObject(fieldName, ts);
            if (valueToCheck != null && valueToCheck.equals(value)) {
                arr.add(ts);
            }
        }
        return this.toArrayFromList(arr);
    }

    private Object getObject(String fieldName, Transaction ts) {
        try {
            Class<Transaction> t = Transaction.class;
            Field f = t.getDeclaredField(fieldName);
            f.setAccessible(true);
            return f.get(ts);
        } catch (NoSuchFieldException | IllegalAccessException noField) {
            noField.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public LocalDate getDate() {
        return null;
    }

    @Override
    public TransactionType getType() {
        return null;
    }

    @Override
    public String getMemo() {
        return this.memo;
    }

    @Override
    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public Payee getPayee() {
        return owner;
    }

    @Override
    public void setPayee(Payee owner) {
        this.owner = owner;
    }

    @Override
    public Double getAmount() {
        return this.amount;
    }
}
