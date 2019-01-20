 

public class TableUtilities {
    public static String getSmallMultiplicationTable() {
        return getMultiplicationTable(5);
    }

    public static String getLargeMultiplicationTable() {
        return getMultiplicationTable(10);
    }

    /**
     * The two above methods, small/large MultiplicationTable, call on the
     * getMultiplicationTable to produce the desired result. 
     * 
     * Originally, the same code was used for each method, and the 
     * "tableSize" parameter was just the req'd table size (ie. 5).
     * 
     * However, since each method returns the same format, calling on 
     * getMultiplicationTable becomes more efficient and cuts down on 
     * repeat code.
     * 
     */
    public static String getMultiplicationTable(int tableSize) {
        StringBuilder multiTable = new StringBuilder();
        // nested for loop
        for (int i = 1; i <= tableSize; i++) {
            for (int j = 1; j <= tableSize; j++) {
                multiTable.append(String.format("%3d |", i * j));
            }
            multiTable.append("\n");
        }
        return multiTable.toString();
    }
}
