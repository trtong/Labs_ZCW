# Checkbook-OldStyle

Create a simple Checkbook class that adheres to java Collections interface.

A new company, ZipMintyFreshness, needs a checkbook account object inside their new mobile offering.

You need to create a class, and 3 tests for every method. (ZipMintyFreshness wants your code
to be SOLID and solid. (get it?))

Maybe you'll get paid.


Checkbook
 needs to organize and track a series of Transaction objects. See the Transaction class file.
 Transaction needs to use a few Payee objects for your tests.
 
* int size()
* boolean isEmpty()
* boolean contains(Transaction element)
* boolean add(Transaction element)
* boolean remove(Transaction element)
* Iterator<Transaction> iterator()
 
AND
 
* Transaction[] toArray()
* <Transaction> Transaction[] toArray(Transaction[] a)
 
* double checkbookValue() // sum of all Transactions (both Debits and Credits)
* Transaction getTransactionsForDate(LocalDate aDate)
* Transaction[] getAllTransactionsForPayee(Payee payee)
* Transaction[] getAllDebitTransactions()
* Transaction[] getAllCreditTransactions()
 
Special Constructors:

* Checkbook(double cashAmount)
* Checkbook(Payee owner, double cashAmount)
 
 
PLUS (For Extra Points, 10 million extra, to be precise)
 
* boolean containsAll(Collection<Transaction> c) 
* boolean addAll(Collection<Transaction> c)
* boolean removeAll(Collection<Transaction> c)
* void clear()

finally, make a generic account class, that takes any class which implements the AccountBook interface.
