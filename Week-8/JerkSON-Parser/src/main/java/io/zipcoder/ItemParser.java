package io.zipcoder;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.zipcoder.LeetUtils.*;

public class ItemParser {

    public static boolean checkForValue(String itemString) {
        Pattern pattern = Pattern.compile("(:;)|(:%)|(:\\*)|(:@)|(:!)");
        Matcher m = pattern.matcher(itemString);

        return m.find();
    }

    public static ArrayList<String> parseRawDataIntoStringArray(String rawData){
        String stringPattern = "##";
        return splitStringWithRegexPattern(stringPattern , rawData);
    }

    public static Item parseStringIntoItem(String rawItem) throws ItemParseException{

        if (checkForValue(rawItem)) {
            throw new ItemParseException();
        } else {
            String[] values = allValues(rawItem.toLowerCase()).split(",");
            return new Item(fullManipulate(values[0]), Double.parseDouble(values[1]), fullManipulate(values[2]), values[3]);
        }
    }

    public static String allValues(String rawItem) {
        StringBuilder sb = new StringBuilder();
        
        ArrayList<String> pairs = findKeyValuePairsInRawItemData(rawItem);
        for (String s: pairs ) {
            sb.append((sb.toString().equals("")) ? returnValue(s) : "," + returnValue(s));
        }
        return sb.toString();
    }

    public static String returnValue (String pair) {
        return pair.substring(pair.lastIndexOf(":") + 1);
    }

    public static ArrayList<String> findKeyValuePairsInRawItemData(String rawItem){
        String stringPattern = "[;^%*@!]";
        return splitStringWithRegexPattern(stringPattern , rawItem);
    }

    private static ArrayList<String> splitStringWithRegexPattern(String stringPattern, String inputString){
        return new ArrayList<>(Arrays.asList(inputString.split(stringPattern)));
    }

    public static void printToFile(String fileName, String rawItemData) throws FileNotFoundException, ItemParseException {

        OutPutObject opo = new OutPutObject(parseRawDataIntoStringArray(rawItemData));
        PrintStream file = new PrintStream(new File(fileName));
        PrintStream console = System.out;

        System.setOut(file);
        System.out.println(opo.outputString());
    }
}
