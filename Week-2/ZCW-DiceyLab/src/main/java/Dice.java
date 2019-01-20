import java.util.Random;

public class Dice {

    // The dice class rolls a number of dice

    private int numberOfDice = 1;

    public Dice(int numOfDice) {

        this.numberOfDice = numOfDice;

    }

    public int tossAndSum() {

        int result = 0;

        for (int i = 0; i < this.numberOfDice; i++) {

            result += (int) (Math.random() * 6) + 1;
        }

        return result;
    }

    public int getNumberOfDice() {
        return this.numberOfDice;
    }

}

