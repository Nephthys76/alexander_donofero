package com.ilmn.donofero;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Consecutive {

    private static final String DELIMITER = ",";

    /**
     * Method to determine number of missing integers within provided list needed to make a consecutive list of ints.
     * If input string is empty, returns 0.
     *
     * @param commaSeparatedListOfInts comma delimited list of ints
     * @return number of missing integers within provided list needed to make a consecutive list of ints
     * @throws NumberFormatException    if element within provided string could not be converted to int
     * @throws IllegalArgumentException if provided string is null
     */
    public static int countMissingInts(String commaSeparatedListOfInts) throws NumberFormatException, IllegalArgumentException {
        /*
        Convert string into separated list
        convert list into ints
        sort
        Figure out count of missing numbers
         */
        if (commaSeparatedListOfInts == null) {
            throw new IllegalArgumentException("Input string is null");
        }
        if (StringUtils.isAllBlank(commaSeparatedListOfInts)) {
            return 0;
        }
        String sanitizedList = commaSeparatedListOfInts.replaceAll("\\s+", "");
        List<String> separatedInts = Arrays.asList(sanitizedList.split(DELIMITER));
        List<Integer> convertedList = new ArrayList<Integer>();
        for (String separatedInt : separatedInts) {
            int converted;
            try {
                converted = Integer.parseInt(separatedInt);
            } catch (NumberFormatException ex) {
                System.out.println(String.format("RECEIVED STRING THAT COULD NOT BE CONVERTED TO INT: %s", separatedInt));
                throw ex;
            }
            if (!convertedList.contains(converted)) {
                convertedList.add(converted);
            }

        }
        Collections.sort(convertedList);
        int missingInts = 0;
        for (int i = 0; i < convertedList.size() - 1; i++) {
            int current = convertedList.get(i);
            int next = convertedList.get(i + 1);
            missingInts += next - current - 1;
        }
        return missingInts;
    }

    public static String printConsecutiveList(String commaSeparatedListOfInts) {
        return "5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15";
    }
}