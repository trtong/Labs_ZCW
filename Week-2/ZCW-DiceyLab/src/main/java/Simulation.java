import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Simulation {

    int dice = 0;
    int tosses = 0;
    Dice simulationDie;
    Bins simulationBins;

    public Simulation(int numberofDie, int numberOfTosses) {
        this.dice = numberofDie;
        this.tosses = numberOfTosses;

        simulationDie = new Dice(numberofDie);

        simulationBins = new Bins(this.dice, this.dice * 6);

        for (int i = 0; i < numberOfTosses; i++) {
            int key = simulationDie.tossAndSum();
            if (simulationBins.hasKey(key)) {
                simulationBins.incrementValue(key);
            }
        }
    }

    public void printToFile() throws FileNotFoundException {
        // Output to file

        PrintStream file = new PrintStream(new File("trinhResults.md"));
        PrintStream console = System.out;

        System.setOut(file);

        StringBuilder resultsOutput = new StringBuilder();

        resultsOutput.append("***\nSimulation of " + this.dice + " dice tossed for " + this.tosses + ".\n***\n\n");

        for (int key: simulationBins.allKeys) {

            int value = simulationBins.results.get(key);

            resultsOutput.append(String.format("%3d : %8d: %4.2f ", key, value, ((double) value / (double) this.tosses)));

            int starCounter = (int) Math.floor((double) ( value / ( this.tosses / 100)));

            resultsOutput.append(repeatString("*", starCounter) + "\n");
        }

        System.out.println(resultsOutput.toString());

    }

    public String repeatString(String stringToRepeat, int numberOfTimes){
        String returnString = "";

        for (int i = 0; i < numberOfTimes; i++) {
            returnString += stringToRepeat;
        }

        return returnString;
    }
}