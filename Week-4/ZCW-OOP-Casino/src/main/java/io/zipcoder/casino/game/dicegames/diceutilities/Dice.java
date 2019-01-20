package io.zipcoder.casino.game.dicegames.diceutilities;

import java.util.Random;

public class Dice {

    RandomDice randomDice = new RandomDice();
    private int numOfDice;

    public Dice(int numOfDice){
        this.numOfDice = numOfDice;
    }

    public int tossAndSum() {

        int sumRoll = 0;

        for (int i = 0; i < numOfDice; i++) {
            sumRoll += randomDice.randDice();
        }
        return sumRoll;
    }

    public int getNumOfDice() {
        return numOfDice;
    }
}
