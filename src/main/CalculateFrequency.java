package main;
import java.util.*;

public class CalculateFrequency {

    /**
     * Reads the list of integers from terminal.
     * @return Entered string.
     */
    public static String[] enterStringOfIntegers(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        return str.split(" ");
    }


    /**
     * Validates users input - checks if it is only numbers.
     * @param stringArray Users entered array.
     * @return Array of numbers.
     */
    public static int[] validateUserInput(String[] stringArray) {
        ArrayList <Integer> intList = new ArrayList<>();
        int numberOfStrings = 0;

        for (int i = 0; i < stringArray.length; i++) {
            try {
                intList.add(Integer.parseInt(stringArray[i]));  //  I use List of integers to eliminate strings
            } catch (NumberFormatException nfe) {
                numberOfStrings += 1;                           //  Eliminated strings where calculated
            }
        }
        if (numberOfStrings > 0){       //  The message about strings in the initial array
            Print.printString("\nThere was/were " + numberOfStrings + " 'strings' in the list. We removed them. Only numbers has left.\n");
        }

        return intList.stream().mapToInt(i->i).toArray();       //  Converting List to Array
    }


    /**
     * Calculates frequency of entered numbers.
     * Uses HashMap to describe number and its frequency.
     * @param A Array of integers.
     * @param min The smallest value in the array.
     * @param max The biggest value in the array.
     * @return HashMap list with numbers from smallest to biggest value and their frequency.
     */
    public static HashMap<Integer, Integer> calculateFrequency(int[] A, int min, int max) {
        HashMap<Integer, Integer> frequencyArray = new HashMap<>();
        int frequency = 0;
        for (int i = min; i <= max; i++) {
            for (int j = 0; j < A.length; j++) {
                if (i == A[j]) {
                    frequency += 1;
                }
            }
            frequencyArray.put(i, frequency);
            frequency = 0;
        }
        return frequencyArray;
    }

    public static void main(String[] args) {
        Print.printGreetingMessage();
        Print.printString("\nEnter integers separated by spaces. At the end of the list push Enter: \n");
        int[] A = validateUserInput(enterStringOfIntegers());
        Print.printString("\nYour provided array of integers: \n");
        Print.printArray(A);
        Arrays.sort(A);
        int min = A[0];
        int max = A[A.length - 1];
        HashMap<Integer, Integer> frequencyArray = calculateFrequency(A, min, max);
        Print.printFrequency(frequencyArray, min, max);
        int maxFrequency = Collections.max(frequencyArray.values());
        Print.printGraph(frequencyArray, maxFrequency, min, max);
    }
}