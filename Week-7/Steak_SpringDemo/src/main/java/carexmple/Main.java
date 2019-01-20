package carexmple;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Audi straightAudi = new Audi();

        straightAudi.run();

        straightAudi.setRun();

        ArrayList<Car> cars = new ArrayList<>();

        cars.add(straightAudi);

    }
}
