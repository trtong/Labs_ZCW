    
    /**
     * Write a description of class TicketMachineCustom here.
     *
     * Updated version of the NaiveTicket Lab File, updated w/ code from
     * the textbook to reflect checks from inputs.
     */
    public class TicketMachineCustom
    {
        // instance variables - replace the example below with your own
        private int price;
        private int balance;
        private int total;
    
        /**
         * Constructor for objects of class TicketMachineCustom
         */
        public TicketMachineCustom(int ticketCost)
        {
            // initialise instance variables
            price = ticketCost;
            balance = 0;
            total = 0;
        }
    
        /** Returns the price of a ticket.
         */
        public int getPrice()
        {
            // put your code here
            return price;
        }
        
        /** Return the amount of money inserted for the next ticket
         * 
         */
        public int getBalance()
        {
            return balance;
        }
        
        /** Taking money, updating the balance
         */
        
        public void insertMoney (int amount)
        {
            if (amount > 0) {
                balance += amount;
            } else {
                System.out.println("Use a positive amount: " + amount);
            }
        }
        
        /** Print a ticket
         * 
         */
        
        public void printTicket()
        {
            if (balance >= price) {
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();
            
            // Update the Total 
            total += balance;
            balance -= price;
        } else {
            System.out.println("Insufficient balance. Insert at least: " + (price - balance) + " cents.");
        }
        }
        
        public int refundBalance() 
        {
            int amountToRefund;
            amountToRefund = balance;
            balance = 0;
            return amountToRefund;
        }
    }
    
