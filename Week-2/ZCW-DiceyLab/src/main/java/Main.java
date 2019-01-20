import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Simulation mainSimulation = new Simulation(2, 1000000);

        mainSimulation.printToFile();
    }
}
