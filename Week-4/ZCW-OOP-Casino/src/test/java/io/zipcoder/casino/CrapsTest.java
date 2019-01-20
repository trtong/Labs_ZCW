package io.zipcoder.casino;

import io.zipcoder.casino.game.Player;
import io.zipcoder.casino.game.dicegames.diceutilities.RandomDice;
import io.zipcoder.casino.game.dicegames.individualdicegames.Craps;
import org.junit.Assert;
import org.junit.Test;

public class CrapsTest {

    Craps craps;
    Player player;
    mockRandom rand = new mockRandom();

    public CrapsTest(){
        player = new Player();
        craps = new Craps(player);
    }

    private class mockRandom extends RandomDice {
        @Override
        public int randDice(){
            return 7;
        }
    }

    @Test
    public void createDiceTest() {
        craps.createDice(2);

        int expected = 2;

        int actual = craps.getPairOfDice().getNumOfDice();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void rollTest() {
        craps.createDice(2);

        boolean actualRoll = false;

        int diceRoll = craps.roll();
        if (diceRoll <= 12 && diceRoll >= 2){
            actualRoll = true;
        }
        //then
        System.out.println(diceRoll);
        Assert.assertTrue(actualRoll);

    }

    @Test
    public void getNumOfRollsTest() {
        int expected = 0;

        int actual = craps.getNumOfRolls();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void playTest() {
    }

    @Test
    public void betTest() {
        craps.win = true;
        craps.bet(10);

        int expected = player.getBank();
        int actual = 10020;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void betTest1() {
        craps.win = false;
        craps.bet(10);

        int expected = player.getBank();
        int actual = 9990;

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void firstRoll() {
        craps.firstRoll();

        Assert.assertTrue(craps.rollOne >= 2 && craps.rollOne <= 12);
    }

    @Test
    public void firstRoll2(){
}

    @Test
    public void secondRoll() {
        craps.secondRoll();

        Assert.assertTrue(craps.rollTwo >= 2 && craps.rollTwo <= 12);
    }

    @Test
    public void secondRoll2() {

    }

    @Test
    public void endGameTest() {
    }

}

