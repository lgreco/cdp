import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * A class emulating Set behavior by providing methods to evaluate
 * the "cardinality" of a list and to determine is the "intersection"
 * of two lists if null or not. The functionality below can be
 * readily achieved by using the Set interface, but the idea is to
 * implement the techniques from the ground up here.
 */
public class WhatAboutSets {

    /**
     * Method that looks at the contents of a list of integers,
     * counts unique values and returns that count. This method
     * is akeen to the cardinality of the list if treared as a
     * mathematical set where duplicate elements do not count.
     * @param inputList List of Integers to have its unique values counted
     * @return count of unique elements in list inputList
     */
    public int countUnique(ArrayList<Integer> inputList){
        int len = inputList.size();
        int element;

        /**
         * Array values will hold each unique value from inputList. If each value
         * in inputList is unique, then inputList.size is same as values.length.
         */
        int[] values = new int[len];
        int valuesIndex = 0;

        Iterator inputListIterator = inputList.iterator();
        while (inputListIterator.hasNext()) {
            element = (int) inputListIterator.next();
            if (valuesIndex == 0) {
                // values[] is empty; no need to scan it. Just add its first
                // element and advance its index.
                values[valuesIndex] = element;
                valuesIndex++;
            } else {
                // values[] is not empty. Let's see if the current element from
                // the inputList is already in values[].
                boolean found = false;
                for (int v = 0; v < valuesIndex; v++) {
                    if (values[v] == element) {
                        found = true;
                    }
                }
                // If the current element from the inputList is not in
                // array values[], add it and advance valuesIndex. If it
                // already exists, no action taken (it's a duplicate
                // element and we are interested only in unique occurrences.
                if (!found) {
                    values[valuesIndex] = element;
                    valuesIndex++;
                }
            }
        }
        /**
         * At this point, valuesIndex reflects the number of unique
         * elements in inputList
         */
        return valuesIndex;
    }

    /**
     * Scans one list againsts the other and terminates the scan if one common
     * element is found. Lists may have more than one common element, but finding
     * one suffices for the purposes of returning a true value in this method.
     * @param listA input list
     * @param listB input list
     * @return true if input lists have a common element
     */
    public boolean listsIntersect(ArrayList<Integer> listA, ArrayList<Integer> listB){
        /** Assume lists do not intersect */
        boolean intersect = false;

        /**
         * Boolean to ensure termination of nested loops if common element
         * if found. This is a time saving measure, to prevent further search
         * after the first common element is found.
         */
        boolean keepLooking = true;

        /** Variables to hold values from the two input list */
        int elementA, elementB;

        /**
         * We set up two iterators over the lists to compare, and run them in
         * a nested fashion. The functionality below can be accomplished with
         * the contains() method. However, the objective here is to reach this
         * functionality using basic statements.
         */
        Iterator a = listA.iterator();
        Iterator b;
        while (a.hasNext() && keepLooking) {
            elementA = (int) a.next();
            // restart the listB iterator every time we check
            // for a different element from listA.
            b = listB.iterator();
            while (b.hasNext() && keepLooking) {
                elementB = (int) b.next();
                // The moment we find a common element, we set the intersect variable
                // to true, and we terminate the loops by setting keepLooking to false
                if (elementA == elementB) {
                    intersect = true;
                    keepLooking = false;
                }
            }
        }
        return intersect;
    }

    public int countCommonElements(ArrayList<Itinerary> listA, ArrayList<Integer> listB) {
        int common = 0;
        return common;
    }

    public static void main(String[] args) {
        WhatAboutSets demo = new WhatAboutSets();
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,1,1,1,1,2,3));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(10,11,3,1,2,15));
        ArrayList<Integer> c = new ArrayList<>();
        System.out.println("\nNumber of unique elements: " + demo.countUnique(a));
        System.out.println();
        String message = demo.listsIntersect(a,b) ? "Lists intersect" : "Lists do not intersect" ;
        System.out.println(message);
        System.out.println();
        message = demo.listsIntersect(a,c) ? "Lists intersect" : "Lists do not intersect" ;
        System.out.println(message);
    }
}
