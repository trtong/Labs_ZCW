import org.junit.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.*;

public class CheckbookTest {
    private Checkbook checkbook, checkbookWithDefault, checkbookWithOwner;
    private Payee p1, p2, p3;
    private Transaction t1, t2, t3, t4;
    private ArrayList<Transaction> outsideTransactions;

    private final double cashAmount = 500.00;
    private final double t2Amount = 100.00;
    private final double t3Amount = 50.00;

    @org.junit.Before
    public void setUp(){

        p1 = new Payee("Bear", "Luna", "luba@gmail.com");
        p2 = new Payee("Bear", "Rocco", "roba@gmail.com");
        p3 = new Payee("Fish", "Salmon", "salmonBear@gmail.com");

        t1 = new Transaction("ZC Fund", p1, TransactionType.CREDIT, cashAmount);
        t2 = new Transaction("Allowance", p3, TransactionType.DEBIT, t2Amount);
        t3 = new Transaction("Food", p2, TransactionType.CREDIT, t3Amount);
        t4 = new Transaction("meow", new Payee(), TransactionType.DEBIT, 10.00);
        outsideTransactions = new ArrayList<>();


        checkbook = new Checkbook(t1, t2, t3);
        checkbookWithDefault = new Checkbook(t2Amount);
        checkbookWithOwner = new Checkbook(p1, t3Amount);

    }

    @Test
    public void testSizeVarConstructor() {
        int expectSizeInitial = 3;
        assertEquals(expectSizeInitial, checkbook.size());
    }

    @Test
    public void testSizeRemove() {
        int expectedSizeRemove = 2;

        checkbook.remove(t1);
        assertEquals(expectedSizeRemove, checkbook.size());
    }

    @Test
    public void testSizeCashAmountConstructor() {
        Transaction t = new Transaction("new", p2, TransactionType.CREDIT, 2.00);
        int expectedSizeAdd = 1;

        checkbookWithDefault.add(t);
        checkbookWithOwner.add(t);

        assertEquals(expectedSizeAdd, checkbookWithDefault.size());
        assertEquals(expectedSizeAdd,checkbookWithOwner.size());

        expectedSizeAdd = 4;
        checkbook.add(t);

        assertEquals(expectedSizeAdd, checkbook.size());
    }

    @Test
    public void testIsEmptyTrueDefault() {
        Checkbook emptyCB = new Checkbook();
        assertTrue(emptyCB.isEmpty());
    }

    @Test
    public void testIsEmptyFalse() {
        assertFalse(checkbook.isEmpty());
    }

    @Test
    public void testIsEmptyRemove() {
        checkbook.remove(t1);
        checkbook.remove(t2);
        checkbook.remove(t3);

        assertTrue(checkbook.isEmpty());
    }

    @Test
    public void testContainsTrue() {
        assertTrue(checkbook.contains(t1));

        checkbookWithDefault.add(t1);
        assertTrue(checkbookWithDefault.contains(t1));

        checkbookWithOwner.add(t3);
        assertTrue(checkbookWithOwner.contains(t3));
    }

    @Test
    public void testContainsFalse() {
        checkbook.remove(t1);
        assertFalse(checkbook.contains(t1));

        assertFalse(checkbookWithDefault.contains(t1));
        assertFalse(checkbookWithDefault.contains(t3));
    }

    @Test
    public void testContains() {

        checkbookWithOwner.add(t1);
        assertTrue(checkbookWithOwner.contains(t1));
        assertFalse(checkbookWithOwner.contains(t2));
    }

    @Test
    public void testIteratorFalse() {
        Checkbook cb = new Checkbook();
        assertFalse(cb.iterator().hasNext());

        assertTrue(checkbook.iterator().hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorException() {
        Checkbook cb = new Checkbook();
        cb.iterator().next();
    }

    @Test
    public void testIteratorTrueFalseFalse() {
        assertTrue(checkbook.iterator().hasNext());
        checkbook.remove(t1);
        checkbook.remove(t2);
        checkbook.remove(t3);

        assertFalse(checkbook.iterator().hasNext());
        assertFalse(checkbook.iterator().hasNext());
    }

    @Test
    public void testToArray() {
        Transaction[] arrEx = {t1, t2, t3};
        assertEquals(arrEx,checkbook.toArray());
    }

    @Test
    public void testToArrayFail() {
        Transaction[] arrUnEx = {};
        assertFalse(arrUnEx.equals(checkbook.toArray()));
    }

    @Test
    public void testToArrayOtherConstructors() {
        Transaction[] arr = {};
        assertEquals(arr, checkbookWithDefault.toArray());

        Transaction[] arr2 = {};
        assertEquals(arr2, checkbookWithOwner.toArray());
    }

    @Test
    public void testToArrayV2() {
        Transaction[] arrEx = {t1, t2, t3};

        assertEquals(arrEx,checkbook.toArray(arrEx));
    }

    @Test
    public void testToArrayFailV2() {
        Transaction[] arrUnEx = {t1, t2};
        Transaction[] arr = {t1};
        assertFalse(Arrays.equals(arr, checkbook.toArray(arrUnEx)));
    }

    @Test
    public void testToArrayOtherConstructorsV2() {
        Transaction[] arr = {t1};
        assertEquals(arr, checkbookWithDefault.toArray(arr));

        Transaction[] arr2 = {t1};
        assertEquals(arr2, checkbookWithOwner.toArray(arr2));
    }

    @Test
    public void testCheckBookValueTrue() {
        double exp = -450.0;
        assertEquals(exp, checkbook.checkbookValue());
    }

    @Test
    public void checkBookValueFalse() {
        double exp = 2.00;
        assertFalse(exp == checkbook.checkbookValue());
        assertFalse(exp == checkbookWithDefault.checkbookValue());
        assertFalse(exp == checkbookWithOwner.checkbookValue());

    }

    @Test
    public void checkBookValueAddRemove() {
        checkbook.add(t1);
        checkbookWithDefault.add(t1);
        checkbookWithOwner.add(t1);

        double expected = -950.00;
        assertEquals(expected, checkbook.checkbookValue());

        expected = -400.0;
        assertEquals(expected, checkbookWithDefault.checkbookValue());

        expected = -450.0;
        assertEquals(expected, checkbookWithOwner.checkbookValue());
    }

    @Test
    public void getTransactionAddingNewTForDate() {
        LocalDate a = LocalDate.of(2018, 12, 05);
        Transaction t = new Transaction("foo", p1, TransactionType.DEBIT, 2.00);

        checkbookWithDefault.add(t);

        for (Transaction ta: checkbookWithDefault.getAllTransactionsForDate(a)) {
            assertEquals(a, ta.getDate());
        }
    }

    @Test
    public void getTransactionsForWrongDate() {
        LocalDate a = LocalDate.of(2220, 10, 20);

        for (Transaction t:checkbook.getAllTransactionsForDate(a)) {
            assertNull(t);
        }
    }

    @Test
    public void getTransactionsForPayeeExists() {
        Payee payee = new Payee();
        Transaction t = new Transaction("test", payee, TransactionType.DEBIT, 10.00);
        Transaction[] expArr = {t};

        checkbook.add(t);
        checkbookWithDefault.add(t);
        checkbookWithOwner.add(t);

        assertEquals(expArr, checkbook.getAllTransactionsForPayee(payee));
        assertEquals(expArr, checkbookWithDefault.getAllTransactionsForPayee(payee));
        assertEquals(expArr, checkbookWithOwner.getAllTransactionsForPayee(payee));
    }

    @Test
    public void getTransactionsForPayeeNotExists() {
        Payee p = new Payee();
        Transaction[] arr = {};
        assertEquals(arr, checkbook.getAllTransactionsForPayee(p));
    }

    @Test
    public void testContainsAll() {
        ArrayList<Transaction> arr = new ArrayList<>();
        arr.add(t1);
        arr.add(t2);

        assertTrue(checkbook.containsAll(arr));
    }

    @Test
    public void testContainsNone() {
        outsideTransactions. add(t4);

        assertFalse(checkbook.containsAll(outsideTransactions));
        assertFalse(checkbookWithOwner.containsAll(outsideTransactions));
        assertFalse(checkbookWithDefault.containsAll(outsideTransactions));
    }

    @Test
    public void testContainsAllAddThenCheck() {

        outsideTransactions.add(t4);
        checkbook.add(t4);
        checkbookWithOwner.add(t4);
        checkbookWithDefault.add(t4);

        assertTrue(checkbook.containsAll(outsideTransactions));
        assertTrue(checkbookWithOwner.containsAll(outsideTransactions));
        assertTrue(checkbookWithDefault.containsAll(outsideTransactions));
    }

    @Test
    public void testAddAll() {
        int expectedSize = 5;
        outsideTransactions.add(t4);
        outsideTransactions.add(t1);

        checkbook.addAll(outsideTransactions);

        assertEquals(expectedSize, checkbook.size());
    }

    @Test
    public void testAddAllNone() {
        int expSize = 3;

        outsideTransactions.clear();
        checkbook.addAll(outsideTransactions);

        assertEquals(expSize, checkbook.size());
    }

    @Test
    public void testAddAllOtherCollection() {
        int expSize = 5;
        Set<Transaction> set = new HashSet<>();
        set.add(t1);
        set.add(t4);

        checkbook.addAll(set);
        assertEquals(expSize, checkbook.size());
    }

    @Test
    public void testRemoveAll() {
        List<Transaction> arrToRemove = new ArrayList<>();
        arrToRemove.add(t1);
        arrToRemove.add(t2);
        arrToRemove.add(t3);

        int expSize = 0;

        checkbook.removeAll(arrToRemove);
        assertEquals(expSize, checkbook.size());
    }

    @Test
    public void testRemoveAllNone() {
        int size = 0;
        Checkbook cb = new Checkbook();
        cb.removeAll(new HashSet<>());
        assertEquals(size, cb.size());
    }

    @Test
    public void testRemoveAllAddNewTransactions() {
        int expSize = 2;
        outsideTransactions.add(t1);
        checkbook.removeAll(outsideTransactions);
        assertEquals(expSize, checkbook.size());
    }

    @Test
    public void testClear() {
        int expSize = 0;

        checkbook.clear();
        checkbookWithDefault.clear();
        checkbookWithOwner.clear();

        assertEquals(expSize, checkbook.size());
        assertEquals(expSize, checkbookWithDefault.size());
        assertEquals(expSize, checkbookWithOwner.size());
    }

    @Test
    public void testClearEmpty() {
        int expSize = 0;
        checkbookWithDefault.clear();
        assertEquals(expSize, checkbookWithDefault.size());
    }

    @Test
    public void testClearAddAndRemove() {
        int expSize = 0;
        checkbookWithOwner.add(t4);
        checkbookWithOwner.clear();

        assertEquals(expSize, checkbookWithOwner.size());
    }

    @Test
    public void testGetDebits() {
        Transaction[] expArr =  {t2};
        assertEquals(expArr, checkbook.getAllDebitTransactions());
    }

    @Test
    public void testGetDebitsNone() {
        Transaction[] arr = {};

        checkbook.remove(t2);

        assertEquals(arr, checkbook.getAllDebitTransactions());
    }

    @Test
    public void testGetDebitsManipulatedCheckbook() {
        Transaction t = new Transaction("foo", new Payee(), TransactionType.DEBIT, 400.00);
        Transaction[] arr = {t};
        checkbook.remove(t2);
        checkbook.add(t);

        assertEquals(arr, checkbook.getAllDebitTransactions());
    }

    @Test
    public void testGetCredits() {
        Transaction[] expArr = {t1, t3};
        assertEquals(expArr, checkbook.getAllCreditTransactions());
    }

    @Test
    public void testGetCreditsNone() {
        Transaction[] expArr = {};
        assertEquals(expArr, checkbookWithDefault.getAllCreditTransactions());
        assertEquals(expArr, checkbookWithOwner.getAllCreditTransactions());
    }

    @Test
    public void testGetCreditsAfterAdding() {
        Transaction t = new Transaction("bar", new Payee(), TransactionType.CREDIT, 10.00);
        Transaction[] arr = {t};

        checkbookWithOwner.add(t);
        assertEquals(arr, checkbookWithOwner.getAllCreditTransactions());
    }
}