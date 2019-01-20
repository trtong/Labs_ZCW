//package io.zipcoder.casino.game.cardgames.individualcardgames;
//
//import io.zipcoder.casino.Console;
//import io.zipcoder.casino.game.Player;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//
//import org.junit.contrib.java.lang.system.SystemOutRule;
//
//import java.util.Scanner;
//
//public class GoFishTest {
//
//    Player player;
//    GoFish goFishTest;
//
//
//    @Before
//    public void setUp() {
//        player = new Player();
//        goFishTest = new GoFish(player);
//    }
//
//    /* Test Section : Setters and Getters */
//    @Test
//    public void testSetPlayerBookTrue() {
//
//        int expectedBookCount = 1;
//
//        goFishTest.setPlayerBook(1);
//
//        int actualBookCount = goFishTest.getPlayerBook();
//
//        Assert.assertEquals(expectedBookCount, actualBookCount);
//    }
//
//    @Test
//    public void testSetPlayerBookFalse() {
//        int expectedBookCount = 1;
//
//        goFishTest.setPlayerBook(18);
//
//        int actualBookCount = goFishTest.getPlayerBook();
//
//        Assert.assertNotEquals(expectedBookCount, actualBookCount);
//
//    }
//
//    @Test
//    public void testSetOpponentBookTrue() {
//
//        int expectedBookCount = 1;
//
//        goFishTest.setOpponentBook(1);
//
//        int actualBookCount = goFishTest.getOpponentBook();
//
//        Assert.assertEquals(expectedBookCount, actualBookCount);
//
//    }
//
//    @Test
//    public void testSetOpponentBookFalse() {
//
//        int expectedBookCount = 1;
//
//        goFishTest.setPlayerBook(18);
//
//        int actualBookCount = goFishTest.getPlayerBook();
//
//        Assert.assertNotEquals(expectedBookCount, actualBookCount);
//
//    }
//
//    @Test
//    public void testSetPlayerTotalCards() {
//        int expectedTotalCards = 7;
//
//        goFishTest.setPlayerTotalCards(7);
//
//        int actualCardCount = goFishTest.getPlayerTotalCards();
//
//        Assert.assertEquals(expectedTotalCards, actualCardCount);
//
//    }
//
//    @Test
//    public void testSetOpponentTotalCards() {
//        int expectedTotalCards = 7;
//
//        goFishTest.setOpponentTotalCards(7);
//
//        int actualCardCount = goFishTest.getOpponentTotalCards();
//
//        Assert.assertEquals(expectedTotalCards, actualCardCount);
//
//    }
//
//    @Test
//    public void testIncrementPlayersBookOnce() {
//
//        int expectedTotalBooks = 2;
//
//        goFishTest.setPlayerBook(1);
//        goFishTest.incrementPlayersBook();
//
//        int actualCardCount = goFishTest.getPlayerBook();
//
//        Assert.assertEquals(expectedTotalBooks, actualCardCount);
//
//    }
//
//    @Test
//    public void testIncrementPlayersBook10Times() {
//
//        int expectedTotalBooks = 10;
//
//        for (int i = 0; i < 10; i++) {
//            goFishTest.incrementPlayersBook();
//        }
//
//        int actualCardCount = goFishTest.getPlayerBook();
//
//        Assert.assertEquals(expectedTotalBooks, actualCardCount);
//
//    }
//
//    @Test
//    public void testIncrementOpponentBookOnce() {
//        int expectedTotalBooks = 2;
//
//        goFishTest.setOpponentBook(1);
//        goFishTest.incrementOpponentBook();
//
//        int actualCardCount = goFishTest.getOpponentBook();
//
//        Assert.assertEquals(expectedTotalBooks, actualCardCount);
//
//    }
//
//    @Test
//    public void testIncrementOpponentBook7Times() {
//
//        int expectedTotalBooks = 7;
//
//        for (int i = 0; i < 7; i++) {
//            goFishTest.incrementOpponentBook();
//        }
//
//        int actualCardCount = goFishTest.getOpponentBook();
//
//        Assert.assertEquals(expectedTotalBooks, actualCardCount);
//
//    }
//
//    @Test
//    public void testDecrementPlayerCards() {
//        int expectedTotalCards = 6;
//
//        goFishTest.setPlayerTotalCards(7);
//        goFishTest.decrementPlayersCards();
//
//        int actualCards = goFishTest.getPlayerTotalCards();
//
//        Assert.assertEquals(expectedTotalCards, actualCards);
//
//    }
//
//    @Test
//    public void testDecrementOpponentCards() {
//        int expectedTotalCards = 3;
//
//        goFishTest.setOpponentTotalCards(4);
//        goFishTest.decrementOpponentCards();
//
//        int actualCards = goFishTest.getOpponentTotalCards();
//
//        Assert.assertEquals(expectedTotalCards, actualCards);
//
//    }
//
//    @Test
//    public void testIncrementPlayersCards() {
//        int expectedTotalCards = 8;
//
//        goFishTest.setPlayerTotalCards(7);
//        goFishTest.incrementPlayersCards();
//
//        int actualCards = goFishTest.getPlayerTotalCards();
//
//        Assert.assertEquals(expectedTotalCards, actualCards);
//
//    }
//
//    @Test
//    public void testIncrementOpponentsCards() {
//        int expectedTotalCards = 5;
//
//        goFishTest.setOpponentTotalCards(4);
//        goFishTest.incrementOpponentCards();
//
//        int actualCards = goFishTest.getOpponentTotalCards();
//
//        Assert.assertEquals(expectedTotalCards, actualCards);
//
//    }
//
//    /* Combination Setters */
//
//    @Test
//    public void testPlayerTurnTrue() {
//
//        int expectedCards = 3;
//        int expectedBooks = 1;
//
//        goFishTest.setPlayerTotalCards(5);
//
//        goFishTest.playerTurnTrue();
//
//        Assert.assertEquals(expectedCards, goFishTest.getPlayerTotalCards());
//        Assert.assertEquals(expectedBooks, goFishTest.getPlayerBook());
//
//    }
//
//    @Test
//    public void testOpponentTurnTrue() {
//
//        int expectedCards = 1;
//        int expectedBooks = 3;
//
//        goFishTest.setOpponentTotalCards(7);
//
//        for (int i = 0; i < 3; i++) {
//            goFishTest.opponentTurnTrue();
//        }
//
//        Assert.assertEquals(expectedCards, goFishTest.getOpponentTotalCards());
//        Assert.assertEquals(expectedBooks, goFishTest.getOpponentBook());
//
//    }
//
//    @Rule
//    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
//
//    @Test
//    public void testPrintSortedHandEmpty() {
//
//        String expectedString = "Your hand: []\n";
//        goFishTest.printSortedHand();
//        Assert.assertEquals(expectedString, systemOutRule.getLog());
//
//    }
//
//    @Test
//    public void testPrintResultPlayerWin() {
//        goFishTest.setPlayerBook(100);
//        goFishTest.printResult();
//
//        String expectedString = "Grats, you won! :)\n";
//
//        Assert.assertEquals(expectedString, systemOutRule.getLog());
//
//    }
//
//    @Test
//    public void testPrintResultOpponentWin() {
//        goFishTest.setOpponentBook(100);
//        goFishTest.printResult();
//
//        String expectedString = "Your opponent won! :(\n";
//
//        Assert.assertEquals(expectedString, systemOutRule.getLog());
//
//    }
//
//    @Test
//    public void testPrintResultDraw() {
//
//        goFishTest.setOpponentBook(50);
//        goFishTest.setPlayerBook(50);
//        goFishTest.printResult();
//        String expectedString = "It was a draw :|\n";
//
//        Assert.assertEquals(expectedString, systemOutRule.getLog());
//    }
//
////    @Test
////    public void testShowRulesY() {
////        Scanner in = new Scanner("y");
////        goFishTest.setConsole(new Console(in));
////
////        goFishTest.showRules();
////
////    }
//
//    @Test
//    public void testShowRulesN() {
//        Scanner in = new Scanner("n");
//        goFishTest.setConsole(new Console(in));
//
//        String expectedString = "Do you want to see the rules? Y or N\n"
//        + "A fishing pro! Game will now start ...\n\n";
//
//        goFishTest.showRules();
//
//        Assert.assertEquals(expectedString, systemOutRule.getLog());
//    }
//
//    @Test
//    public void testShowRulesInvalid() {
//
//        // if invalid entry, catch the exception and assert that
//
//    }
//
//    @Test
//    public void testRulesPrint() {
//        String expectedString = "Go Fish a game for all ages!"
//                + "\nEach player starts with 7 cards and the object of the game "
//                + "\nis to collect books, which are pairs of the same card number/rank."
//                + "\nFor example, a Three of hearts and a Three of diamonds makes a book!"
//                + "\ngame ends when the pile of cards is empty or one player has more than 13 pairs."
//                + "\n\nEach round, the player will ask the opponent if they have a card, but the card"
//                + "\nthe player asks for must be in their hand!"
//                + "\nIf the opponent has the card, they have to give ALL the cards that match that card "
//                + "\nto the player asking. If the opponent doesn't have it, the player must \"go fish\"."
//                + "\nGo fish means you have to get 1 card from the pile (all the leftover cards)."
//                + "\nThe first player to empty their hand wins!"
//                + "\nGood luck! :) \n\n\n";
//
//        goFishTest.rules();
//        Assert.assertEquals(expectedString, systemOutRule.getLog());
//    }
//
//}