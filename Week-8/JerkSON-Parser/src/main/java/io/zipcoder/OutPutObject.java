package io.zipcoder;

import java.util.ArrayList;
import java.util.HashMap;

import static io.zipcoder.ItemParser.checkForValue;
import static io.zipcoder.ItemParser.parseStringIntoItem;
import static io.zipcoder.LeetUtils.*;
import static io.zipcoder.LeetUtils.errorLine;

public class OutPutObject {
    private int errorCount;
    private HashMap<String, SameItems> allItemCounts;
    private ArrayList<String> rawInputArray;
    private ArrayList<Item> allItems;

    public OutPutObject(ArrayList<String> rawInputArray) throws ItemParseException {
        this.rawInputArray = rawInputArray;
        this.allItems = new ArrayList<>();
        errorCount = 0;

        errorsAndCounts();
        sameItemCounter(this.allItems);
        allItemCounts = sameItemCounter(this.allItems);
    }

    public int getErrorCount() {
        return errorCount;
    }

    public HashMap<String, SameItems> getAllItemCounts() {
        return allItemCounts;
    }

    private void addErrorCount() {
        this.errorCount = getErrorCount() + 1;
    }

    private void errorsAndCounts() throws ItemParseException {
        for (String s:this.rawInputArray) {
            if (checkForValue(s)) {
                addErrorCount();
            } else {
                allItems.add(parseStringIntoItem(s));
            }
        }
    }

    private HashMap<String, SameItems> sameItemCounter(ArrayList<Item> allItems) {

        HashMap<String, SameItems> itemCounters = new HashMap<>();
        for (Item i: allItems) {
            SameItems temp;
            if (!itemCounters.keySet().contains(i.getName())) {
                temp = new SameItems(i.getName());
                temp.getPrices().addNewPrice(i.getPrice());
                itemCounters.put(i.getName(), temp);
            } else {
                temp = itemCounters.get(i.getName());
                if (!temp.getPrices().getPrices().keySet().contains(i.getPrice())) {
                    temp.getPrices().addNewPrice(i.getPrice());
                } else {
                    temp.getPrices().IncrementPriceCounter(i.getPrice());
                }
                temp.setCount(temp.getCount() + 1);
                itemCounters.put(i.getName(),temp);
            }
        }
        return itemCounters;
    }

    public String outputString() {
        StringBuilder resultsOutput = new StringBuilder();
        resultsOutput.append("Tariq's Messed up Grocery List...\n\n");

        for (SameItems s : this.getAllItemCounts().values()) {
            resultsOutput.append(stringFormatName(s.getName(), s.getCount()));
            resultsOutput.append(doubleLine());

            for (Double d:s.getPrices().getPrices().keySet()) {
                resultsOutput.append(stringFormatPrice(d, s.getPrices().getCount(d), "Price", "seen"));
                resultsOutput.append(singleLine());
            }
        }

        resultsOutput.append(errorLine(this.getErrorCount()));
        return resultsOutput.toString();
    }
}
