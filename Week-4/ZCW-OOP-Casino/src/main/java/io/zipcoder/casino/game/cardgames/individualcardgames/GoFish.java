package io.zipcoder.casino.game.cardgames.individualcardgames;
import io.zipcoder.casino.Console;
import io.zipcoder.casino.game.Player;
import io.zipcoder.casino.game.cardgames.cardutilities.Card;
import io.zipcoder.casino.game.cardgames.cardutilities.Rank;

import java.util.*;

public class GoFish extends CardGame {

    private Player player;

    private ArrayList<Card> playerHand;

    private ArrayList<Card> opponentHand;

    private Card[] playerBookCheck;
    private Card[] opponentBookCheck;

    private HashMap<String, Integer> allRanks;

    private boolean endGameCheck;

    private int playerBook;
    private int opponentBook;

    private int playerTotalCards;
    private int opponentTotalCards;

    private int turnOrder;

    private Console console;

    public GoFish(Player player) {

        this.player = player;

        playerHand = getPlayerHand();
        opponentHand = getHouseHand();

        playerBookCheck = new Card[13];
        opponentBookCheck = new Card[13];

        playerBook = 0;
        opponentBook = 0;
        endGameCheck = false;

        playerTotalCards = 0;
        opponentTotalCards = 0;

        turnOrder = randomTurnOrder();

        allRanks = new HashMap<>();
        for (Rank r: Rank.values()) {
            allRanks.put(r.getThirdvalue(), r.getValue() - 1);
        }

        console = new Console();
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    public void play() {

        startOfGame();
        firstBookCheck();

        turnOrder = playerGoesFirst();

        while (!endGameCheck) {
            gameTurnOrder(turnOrder);
        }

        this.console.print("Thanks for playing! \n ... Returning to main menu.");
    }

    public void gameTurnOrder(int turnOrder) {
        if (turnOrder == 0) {
            playerTurn();
            opponentTurn();
            bookStandings();

        } else {
            opponentTurn();
            playerTurn();
            bookStandings();
        }
    }

    public void startOfGame() {
        this.console.print("Welcome to go fish, " + player.getName() + "!");
        showRules();
        startDealHands();
    }

    public void firstBookCheck() {
        this.console.print("Checking dealt hands for books... ");
        this.console.pause(250, " . ", 5);

        updateBookChecker(playerHand, playerBookCheck, true);
        updateBookChecker(opponentHand, opponentBookCheck, false);

        bookStandings();

    }

    public void bookStandings() {
        this.console.print("\n\nCurrent book standings!"
                + "\n" + player.getName() + "'s Books: " + getPlayerBook()
                + "\nOpponent's Books: " + getOpponentBook() + "\n\n");
    }

    public void startDealHands() {

        this.console.print("Dealing cards...");
        this.console.pause(250, " . ", 5);

        dealHand(7);
        setPlayerTotalCards(getPlayerHand().size());
        setOpponentTotalCards(getPlayerHand().size());

    }

    private void updateBookChecker(ArrayList<Card> hand, Card[] bookCheck, boolean isPlayersTurn) {
        int cardIndex;
        for(Card c: hand) {

            cardIndex = c.getValue().getValue() - 1;
            if (bookCheck[cardIndex] == null) {
                bookCheck[cardIndex] = c;
            } else {

                addBookCountDecreaseCardTotal(isPlayersTurn);
                removeBook(bookCheck, cardIndex, c, determineName(isPlayersTurn));

            }
        }
    }

    private int randomTurnOrder() {
        Random random = new Random();
        return random.nextInt(2);
    }

    private int playerGoesFirst() {

        this.console.print("Determining who goes first...");
        this.console.pause(250, " . ", 5);

        if (this.turnOrder == 0) {
            this.console.print("You go first!");
            return 0;
        } else {
            this.console.print("Your opponent goes first...");
        }

        return 1;
    }

    public void increaseTotalCards(boolean isPlayersTurn) {
        if (isPlayersTurn) {
            incrementPlayersCards();
        } else {
            incrementOpponentCards();
        }
    }

    public void addBookCountDecreaseCardTotal(boolean isPlayersTurn) {
        if (isPlayersTurn) {
            playerTurnTrue();
        } else {
            opponentTurnTrue();
        }
    }

    public String determineName(boolean isPlayerTurn) {
        if (isPlayerTurn) {
            return player.getName();
        } else {
            return "Opponent";
        }
    }

    private void goFish(Card[] hand, boolean isPlayersTurn) {

        Card newCard = deck.dealCard();
        int newCardIndex = newCard.getValue().getValue() - 1;

        this.console.print("\nGO FISH!\n"
                + "Adding " + newCard.toString() + " to the hand.");

        if (hand[newCardIndex] != null) {
            removeBook(hand, newCardIndex, newCard, determineName(isPlayersTurn));
            addBookCountDecreaseCardTotal(isPlayersTurn);

        } else {
            hand[newCardIndex] = newCard;
            increaseTotalCards(isPlayersTurn);

        }
    }

    public boolean endGame() {
        return (deck.getDeck().isEmpty() || playerBook >= 13 || opponentBook >= 13);
    }

    private boolean checkRank(String s) {
        return allRanks.get(s) != null;
    }

    public String startPlayerTurn() {

        String userAsk = this.console.printAndTakeString("What card do you want to ask for?");

        if (!checkRank(userAsk)) {
            userAsk = this.console.printAndTakeString("Invalid entry type,"
                + "try typing out the card number/face.. ie. Ace or two\n");
        }

        return userAsk.toLowerCase();
    }

    public void updateBookCheckerRemove(Card[] takeFrom, Card requestedCard) {
        this.console.print("Found a card! Adding " + requestedCard.toString() + " to hand.");
        takeFrom[allRanks.get(getRankString(requestedCard))] = null;
    }


    public boolean addAsktoHand(Card[] takeFromThisHand, Card[] addToThisHand , String userAsk, boolean isPlayersTurn) {

        Card requestedCard = takeFromThisHand[allRanks.get(userAsk)];

        if (requestedCard != null) {
            updateBookCheckerRemove(takeFromThisHand, requestedCard);

            if (addToThisHand[allRanks.get(userAsk)] != null) {

                removeBook(addToThisHand, requestedCard.getValue().getValue()-1, requestedCard, determineName(isPlayersTurn));
                addBookCountDecreaseCardTotal(isPlayersTurn);

            } else {

                addToThisHand[allRanks.get(userAsk)] = requestedCard;
                increaseTotalCards(isPlayersTurn);

            }
        }

        return requestedCard != null;
    }

    public void removeBook(Card[] hand, int cardIndex, Card c, String s) {
        this.console.print("Removing cards " + c.toString() + " and " + hand[cardIndex].toString() + " from " + s + "'s hand.");
        hand[cardIndex] = null;
    }

    public void checkEmptyHand(int totalCards, boolean isPlayersTurn) {
        if (totalCards < 0) {
            Card newCard = deck.dealCard();
            int newCardIndex = newCard.getValue().getValue() - 1;

            if (isPlayersTurn) {
                emptyHand(playerBookCheck, newCard, isPlayersTurn, newCardIndex);
            } else {
                emptyHand(opponentBookCheck, newCard, false, newCardIndex);
            }
        }
    }

    public void emptyHand(Card[] bookChecker, Card newCard, boolean isPlayersTurn, int newCardIndex){

        this.console.print("Adding "
                + newCard.toString() + " to "
                + determineName(isPlayersTurn) + "'s hand.");

        bookChecker[newCardIndex] = newCard;

        if (isPlayersTurn) {
            incrementPlayersCards();
        } else {
            incrementOpponentCards();
        }
    }


    private void playerTurn() {

        boolean validCardAsked = false;

        printSortedHand();

        checkEmptyHand(getPlayerTotalCards(),true);

        while (!validCardAsked) {
            String cardAskedFor = startPlayerTurn();
            checkingOpponentHand();

            if (checkHandForCard(playerBookCheck, cardAskedFor)) {

                if (!addAsktoHand(opponentBookCheck, playerBookCheck, cardAskedFor, true)) {
                    goFish(playerBookCheck, true);
                }
                validCardAsked = true;
            } else {
                this.console.print("You don't have that card! Try again...");
            }
        }

        checkPlayerBook();
        endGameCheck = endGame();
        endCheck(true);
    }

    private void checkingOpponentHand() {
        this.console.print("Checking opponent's hand...");
        this.console.pause(250, " . ", 5);
    }

    private boolean checkHandForCard(Card[] cards, String string) {
        return cards[allRanks.get(string)] != null;
    }

    private void checkPlayerBook() {
        this.console.print("\nChecking for books... ");
        this.console.pause(350, " . ", 5);
        this.console.print("You have " + playerBook + " book(s).\n");
    }

    private void opponentTurn() {
        printSortedHand();
        opponentAsk();
        endGameCheck = endGame();
        endCheck(false);
    }

    private void opponentAsk() {

        this.console.print("Opponent's turn...\n");

        checkEmptyHand(getOpponentTotalCards(),false);

        Card randomCard = randomCardOpponentAsks();

        String opponentAsk = getRankString(opponentBookCheck[randomCard.getValue().getValue()-1]);

        this.console.print("Opponent is asking for " + opponentAsk + "'s. \nSearching your hand...");
        this.console.pause(250, " . ", 5);

        if (!addAsktoHand(playerBookCheck, opponentBookCheck, opponentAsk, false)) {
            goFish(opponentBookCheck, false);
        }
    }

    public Card randomCardOpponentAsks() {
        Random random = new Random();
        int result = random.nextInt(opponentTotalCards);
        int counter = 0;

        Card randomCard = null;
        for (int i = 0; i < opponentBookCheck.length; i++) {
            if (opponentBookCheck[i] != null) {
                counter++;
                randomCard = opponentBookCheck[i];

                if (counter >= result) {
                    break;
                }
            }
        }

        return randomCard;
    }

    public void notGameOver(Card[] bookCheck) {
        this.console.print("The hand is empty! Adding a card...");
        Card newCard = deck.dealCard();
        bookCheck[newCard.getValue().getValue() - 1] = newCard ;

    }

    private void endCheck(boolean isPlayersTurn) {
        if (endGameCheck) {
            printResult();
        } else {
            if (isPlayersTurn && playerTotalCards == 0) {

                notGameOver(playerBookCheck);
                incrementPlayersCards();

            } else if (opponentTotalCards == 0) {

                notGameOver(opponentBookCheck);
                incrementOpponentCards();
            }

            this.console.print("+++++ End of Turn +++++\n\n");
        }

        this.console.pause(350, " . ", 5);
    }

    private String getRankString(Card c) {
        return c.getValue().getThirdvalue();
    }

    public void showRules() {

        boolean validInput = false;

        this.console.print("Do you want to see the rules? Y or N");

        while(!validInput) {
            String userRuleSelect = this.console.getStringInput().toLowerCase();

            switch (userRuleSelect) {
                case "y" :
                    rules();
                    pressEnterToContinue();
                    validInput = true;
                    break;
                case "n":
                    this.console.print("A fishing pro! Game will now start ...\n");
                    validInput = true;
                    break;
                default:
                    this.console.print("Invalid entry, try \'Y\' or \'N\'");
                    break;
            }
        }
    }

    public void rules() {

        this.console.print("Go Fish a game for all ages!"
                + "\nEach player starts with 7 cards and the object of the game "
                + "\nis to collect books, which are pairs of the same card number/rank."
                + "\nFor example, a Three of hearts and a Three of diamonds makes a book!"
                + "\ngame ends when the pile of cards is empty or one player has more than 13 pairs."
                + "\n\nEach round, the player will ask the opponent if they have a card, but the card"
                + "\nthe player asks for must be in their hand!"
                + "\nIf the opponent has the card, they have to give ALL the cards that match that card "
                + "\nto the player asking. If the opponent doesn't have it, the player must \"go fish\"."
                + "\nGo fish means you have to get 1 card from the pile (all the leftover cards)."
                + "\nThe first player to empty their hand wins!"
                + "\nGood luck! :) \n\n");
    }

    private void pressEnterToContinue()
    {
        this.console.print("Press Enter key to continue...");
        try {
            System.in.read();
        } catch(Exception e) {
        }
    }

    public void printResult() {
        if (opponentBook > playerBook) {
            this.console.print("Your opponent won! :(");
        } else if (opponentBook == playerBook) {
            this.console.print("It was a draw :|");
        } else {
            this.console.print("Grats, you won! :)");
        }
    }

    public void printSortedHand() {
        this.console.printInSameLine("Your hand: [");

        boolean firstCard = true;

        for (int i = 0; i < playerBookCheck.length; i++) {

            if (playerBookCheck[i] != null) {
                if (!firstCard) { this.console.printInSameLine(", ");
                }
                this.console.printInSameLine(playerBookCheck[i].toString());
                firstCard = false;
            }

        }
        this.console.printInSameLine("]\n");
    }

    public int getPlayerBook() {
        return playerBook;
    }

    public void setPlayerBook(int playerBook) {
        this.playerBook = playerBook;
    }

    public int getOpponentBook() {
        return opponentBook;
    }

    public void setOpponentBook(int opponentBook) {
        this.opponentBook = opponentBook;
    }

    public int getPlayerTotalCards() {
        return playerTotalCards;
    }

    public void setPlayerTotalCards(int playerTotalCards) {
        this.playerTotalCards = playerTotalCards;
    }

    public int getOpponentTotalCards() {
        return opponentTotalCards;
    }

    public void setOpponentTotalCards(int opponentTotalCards) {
        this.opponentTotalCards = opponentTotalCards;
    }

    public void incrementPlayersBook() {
        setPlayerBook(getPlayerBook() + 1);
    }

    public void incrementOpponentBook() {
        setOpponentBook(getOpponentBook() + 1);
    }

    public void decrementPlayersCards() {
        setPlayerTotalCards(getPlayerTotalCards() - 1);
    }

    public void decrementOpponentCards() {
        setOpponentTotalCards(getOpponentTotalCards() - 1);
    }

    public void incrementPlayersCards() {
        setPlayerTotalCards(getPlayerTotalCards() + 1);
    }

    public void incrementOpponentCards() {
        setOpponentTotalCards(getOpponentTotalCards() + 1);
    }


    public void playerTurnTrue() {
        incrementPlayersBook();
        decrementPlayersCards();
        decrementPlayersCards();
    }

    public void opponentTurnTrue(){
        incrementOpponentBook();
        decrementOpponentCards();
        decrementOpponentCards();
    }
}
