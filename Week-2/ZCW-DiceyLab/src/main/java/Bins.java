import java.util.HashMap;
import java.util.Set;

public class Bins {
    public HashMap<Integer, Integer> results;

    int min = 0;

    int max = 0;

    Set<Integer> allKeys;
    // creates an array of required length
    // increments the array @ index roll properly

    public Bins(int min, int max) {

        this.min = min;
        this.max = max;


        this.results = new HashMap<Integer, Integer>();

        for (int i = min; i <= max; i++) {
            this.results.put(i, 0);
        }

        allKeys = this.results.keySet();
    }

    public boolean hasKey(int key) {

        boolean hasKeyToken = false;

        for (int diceRoll: allKeys) {
            if (key == diceRoll) {
                hasKeyToken = true;
                break;
            }
        }

        return hasKeyToken;
    }

    public void incrementValue(int key) {

        this.results.put(key, this.results.get(key) + 1);

    }
}
