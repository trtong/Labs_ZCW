import java.util.*;

import java.util.*;

    public class GoFish extends CardGame {

        Player player;

        private ArrayList<Card> pile;
        private ArrayList<Card> userHand;
        private ArrayList<Card> opponentHand;

        private boolean endGameCheck;

        private int playerBook;
        private int opponentBook;

        public GoFish(Player player) {

            pile = new ArrayList<>();
            this.player = player;

            userHand = getPlayerHand();
            opponentHand = getHouseHand();

            playerBook = 0;
            opponentBook = 0;
            endGameCheck = false;

        }

        public void play() {

            Console.print("Welcome to go fish!");
            dealHand(7);
            createPile();
            showRules();

            boolean playerGoesFirst = playerGoesFirst();

            while (!endGameCheck) {
                if (playerGoesFirst) {
                    playerTurn();
                    Console.pause(1000/2, " . ", 5);
                    opponentTurn();

                } else {
                    Console.print("Here's your hand!\n");
                    printUserHand();
                    Console.pause(5/2, " . ", 5);
                    opponentTurn();
                    playerTurn();
                }
            }

            // Add replay method
            // add quit method

            Console.print("Thanks for playing! \n ... Returning to main menu.");

        }

        public boolean playerGoesFirst() {
            boolean playerGoes = false;

            Console.print("Determining who goes first...");
            Console.pause(500/2, " . ", 5);

            Random random = new Random();

            int result = random.nextInt(2);

            if (result == 0) {
                playerGoes = true;
                Console.print("You go first!");
            } else {
                Console.print("The computer goes first...");
            }
            return playerGoes;
        }

        public void createPile() {
            while (!deck.getDeck().isEmpty()) {
                pile.add(deck.dealCard());
            }
        }

        public void goFish(ArrayList<Card> hand) {

            if (pile.size() > 0) {
                hand.add(pile.get(0));
                pile.remove(0);

            } else {
                Console.print("Looks like the pile is empty... No card added.\n");
            }
        }

        // method to sort hand

        public String sortHand(ArrayList<Card> hand) {

            hand.sort(Comparator.comparing(Card::getValue));

            return hand.toString();
        }

        public boolean checkHands(ArrayList<Card> cards, String string) {
            boolean hasCard = false;

            for (Card c: cards) {
                if (getRankString(c).equals(string)) {
                    hasCard = true;
                    break;
                }
            }
            return hasCard;
        }

        public boolean endGame() {
            boolean gameOver = false;

            if (pile.size() == 0 || playerBook > 13 || opponentBook > 13) {
                gameOver =  true;
            }

            return gameOver;
        }

        public boolean addAsktoHand(ArrayList<Card> takeFromThisHand, ArrayList<Card> addToThisHand , String userAsk) {
            boolean addedCards = false;
            for (Card c: takeFromThisHand) {
                // add all the cards that match what user asked
                if (getRankString(c).equals(userAsk)) {
                    Console.print("Found a card! Adding " + c.toString() + " to hand.");
                    addToThisHand.add(c);
                    addedCards = true;
                }
            }

            if (addedCards) {
                removeCard(takeFromThisHand, userAsk);
            }

            if (!addedCards) {
                Console.print("No cards of that number found, sorry!");
                Console.print("GO FISH!");
                goFish(addToThisHand);
            }

            return addedCards;
        }

        public boolean checkRank(String s) {

            boolean validRank = false;

            ArrayList<String> rankStrings = new ArrayList<>();
            for (Rank r: Rank.values()) {
                rankStrings.add(r.getThirdvalue());
            }

            for (String str: rankStrings) {
                if (str.equals(s)) {
                    validRank = true;
                    break;
                }
            }

            return validRank;
        }

        // check string to int, if true, throw error

        public String validInputString() {

            String s = "";
            boolean validInput = false;

            while (!validInput) {
                s = Console.getStringInput();
                if (checkRank(s)) {
                    validInput = true;
                } else {
                    Console.print("Invalid entry type, try typing out the card number/face.. ie. Ace or two\n");
                }
            }

            return s.toLowerCase();
        }

        public int checkForBooks(ArrayList<Card> hand) {

            // evals the hand for pairs
            // increases book if pairs found
            // removes the pairs

            boolean hasFoundBook = false;
            int bookCount = 0;



            ArrayList<String> deleteCards =  new ArrayList<>();

            // loop to compare cards to find doubles
            HashMap<String, Integer> tempHand = new HashMap<>();

            for (Card c: hand) {
                if (!tempHand.containsKey(getRankString(c))) {
                    tempHand.put(getRankString(c), 1);
                } else if (tempHand.containsKey(getRankString(c))) {
                    // Null pointer exception
                    tempHand.put(getRankString(c), tempHand.get(getRankString(c)) + 1);
                }
            }

            for (String k : tempHand.keySet()) {
                if (tempHand.get(k) > 1) {
                    deleteCards.add(k);
                    hasFoundBook = true;

                    Console.print("Congrats! Found a book of "
                            + k
                            + "'s."
                            + "\nRemoving the book from the hand...\n\n");
                    bookCount++;
                }
            }

            // delete cards
            if (hasFoundBook && deleteCards.size() > 0) {
                // Null pointer exception
                for (String valueToDelete : deleteCards) {
                    removeCard(hand, valueToDelete);
                }
            } else {
                Console.print("Sorry, no books found, yet!");
            }

            return bookCount;

        }

        public int getPlayerBook() {
            return playerBook;
        }

        public void removeCard(ArrayList<Card> hand, String value) {

            for (int i = 0; i < hand.size(); i ++) {
                if (getRankString(hand.get(i)).equals(value)) {
                    hand.remove(hand.get(i));
                }
            }
        }

        public String startPlayerTurn() {

            boolean validRank = false;
            Console.print("What card do you want to ask for?\n");

            String userAsk = validInputString();

            // Checks the user put in a card rank, not just any number
            while (!validRank) {
                if (!checkRank(userAsk)) {
                    userAsk = validInputString();
                } else if (checkRank(userAsk)) {
                    validRank = true;
                }
            }

            return userAsk.toLowerCase();
        }

        public void playerTurn() {

            boolean validCardAsked = false;
            boolean showFishedCard = true;

            Console.print("Your turn to ask for a card.. here's your hand!");
            printUserHand();

            while (!validCardAsked) {
                // Starts by user inputting a card to ask for
                String cardAskedFor = startPlayerTurn();

                // Checks players hand and then opponents hand
                if (checkHands(userHand, cardAskedFor)) {
                    Console.print("Checking opponent's hand...");
                    Console.pause(500/2, " . ", 5);
                    showFishedCard = addAsktoHand(opponentHand, userHand, cardAskedFor);
                    validCardAsked = true;

                    if (!showFishedCard) {
                        Console.print("Adding " + userHand.get(userHand.size() - 1).toString() + " to the hand.");
                    }

                } else {
                    Console.print("You don't have that card! Try again...");
                }
            }

            // Check for books

            Console.print("\nChecking for books... ");
            Console.pause(500/2, " . ", 5);
            int addBookCounter = checkForBooks(userHand);
            // Print num of books
            setPlayerBook(getPlayerBook() + addBookCounter);

            Console.print("You have " + getPlayerBook() + " book(s).\n");

            // End of turn
            Console.print("+++++ Turn over! +++++\n\n");

            // Check game over

            endGameCheck = endGame();

            if (endGameCheck) {
                printResult();
            } else {
                Console.print("+++++ Turn over! +++++\n\n");
            }
        }

        public void opponentTurn() {

            // Opponent's turn... Random card chosen from their hand to ask.
            Console.print("Opponent's turn...\n");

            // shuffles opponent's hand to ask for the first card in it
            Collections.shuffle(opponentHand);
            String opponentAsk = getRankString(opponentHand.get(0));

            Console.print("Opponent is asking for " + opponentAsk + "'s.");
            Console.print("Searching your hand...");

            Console.pause(500/2, " . ", 5);

            addAsktoHand(userHand, opponentHand, opponentAsk);

            Console.print("\nChecking opponent's hand for books...");
            Console.pause(500/2, " . ", 5);


            int addBookCounter = checkForBooks(opponentHand);
            // Print num of books
            setOpponentBook(getOpponentBook() + addBookCounter);

            Console.print("Opponent has " + getOpponentBook() + " book(s).\n");

            endGameCheck = endGame();

            if (endGameCheck) {
                printResult();
            } else {
                Console.print("+++++ End of Opponent's Turn +++++\n\n");
            }

            Console.pause(700/2, " . ", 5);


        }

        public String getRankString(Card c) {

            return c.getValue().getThirdvalue();
        }


        public void showRules() {
            boolean validInput = false;
            String userRuleSelect = "";
            Console.print("Do you want to see the rules? Y or N");

            while (!validInput) {
                try {
                    userRuleSelect = Console.getStringInput().toLowerCase();
                    validInput = true;
                } catch (InputMismatchException e) {
                    Console.print("Invalid entry, try \'Y\' or \'N\'");
                }
            }

            if (userRuleSelect.equals("y")) {
                rules();
            }
        }

        public void rules() {

            Console.print("Go Fish a game for all ages!"
                    + "\nEach player starts with 7 cards and the object of the game "
                    + "\nis to collect books, which are pairs of the same card number/rank."
                    + "\nFor example, a Three of hearts and a Three of diamonds makes a book!"
                    + "\nGame ends when the pile of cards is empty or one player has more than 13 pairs."
                    + "\n\nEach round, the player will ask the opponent if they have a card, but the card"
                    + "\nthe player asks for must be in their hand!"
                    + "\nIf the opponent has the card, they have to give ALL the cards that match that card "
                    + "\nto the player asking. If the opponent doesn't have it, the player must \"go fish\"."
                    + "\nGo fish means you have to get 1 card from the pile (all the leftover cards)."
                    + "\nThe first player to empty their hand wins!"
                    + "\nGood luck! :) \n\n"
                    + "Game will start automatically!\n\n");

            Console.pause(10000/2, " . ", 5);
            Console.print("\nGame will now start!\n");

            Console.pause(1000/2, " . ", 5);

        }

        public void printResult() {
            if (getOpponentBook() > getPlayerBook()) {
                Console.print("Your opponent won! :( ");
            } else if (getOpponentBook() == getPlayerBook()) {
                Console.print("It was a draw :|");
            } else {
                Console.print("Grats, you won! :)");
            }
        }


        public void printUserHand() {
            Console.print("Your hand: " + sortHand(userHand) + "\n");
        }

        public void setPlayerBook(int playerBook) {
            this.playerBook = playerBook;
        }

        public void setOpponentBook(int opponentBook) {
            this.opponentBook = opponentBook;
        }

        public int getOpponentBook() {
            return opponentBook;
        }
    }

