package main;
import java.util.HashMap;

public class Print {
    /**
     * Prints welcome message
     */
    public static void printGreetingMessage(){
        System.out.println((char) 27 + "[32m/**");
        System.out.println("* This program calculates the frequency of numbers in a list.");
        System.out.println("* Enter array of integers from -99 to 1000 separated by space and press Enter.");
        System.out.println("*/");   //  The system works in wider range, but with 'bigger' minus is wrong alignment
        System.out.println((char) 27 + "[0m");
    }


    /**
     * Prints strings.
     * @param string The string that system sends for printing.
     */
    public static void printString(String string){
        System.out.printf((char) 27 + "[0;1m%4s", string);
    }


    /**
     * Prints arrays.
     * @param intArray The array that system sends for printing.
     */
    public static void printArray(int[] intArray){
        for (int i = 0; i < intArray.length; i++){
            System.out.printf((char) 27 + "[0;1m%3s", intArray[i]);
        }
    }


    /**
     * Prints the numbers from min to max values amd their frequency.
     * @param frequencyArray Hash Map list with numbers and their frequency.
     * @param min The smallest value in the array.
     * @param max The biggest value in the array.
     */
    public static void printFrequency(HashMap frequencyArray, int min, int max) {
        System.out.print((char) 27 + "[1;34m\n\nFrequency: ");
        int iCopy;  //  using for digits calculation. When I have more digits, need more spaces between numbers (and minus)
        int spaces = 0;

        for (int i = min; i <= max; i++) {
            iCopy = i;
            while (iCopy != 0) {
                iCopy = iCopy / 10;
                spaces++;                   //  Calculating spaces
            }
            for (int k = 1; k < spaces; k++){
                System.out.print("  ");     // Printing spaces between numbers
            }
            spaces = 0;
            System.out.printf((char)27 + "[0;1m%3s", frequencyArray.get(i));
        }

        System.out.println((char) 27 + "[0m");
        System.out.print((char) 27 + "[1;34mNumber:    ");
        for (int i = min; i <= max; i++) {
            iCopy = i;
            while (iCopy != 0) {
                iCopy = iCopy / 10;
                spaces++;
            }
            for (int k = 1; k < spaces; k++){
                System.out.print("  ");
            }
            spaces = 0;
            System.out.printf((char) 27 + "[0;1m%3s", i);
        }
        System.out.println("\n");
    }


    /**
     * Generates a graph of numbers frequency.
     * @param frequencyArray Array of meaning values from 0 till maximum element in the list.
     * @param maxFrequency The biggest value of frequency.
     * @param min Minimum value of array list.
     * @param max Maximum value of array list.
     */
    public static void printGraph(HashMap<Integer, Integer> frequencyArray, int maxFrequency, int min, int max){

        while (maxFrequency > 0){                                   //  Printing from the 'top'
            for (int i = min; i <= max; i++){
                if(maxFrequency - frequencyArray.get(i) > 0 ){      // Checking what to print: space or *
                    Print.printString(" ");
                } else{
                    Print.printString("*");
                }
            }
            System.out.println("");
            maxFrequency -= 1;                                      // Printing 'goes' down
        }

        for (int i = min; i <= max; i++){       //  Prints the last line (only numbers) in graph
            Print.printString(String.valueOf(i));
        }
        Print.printString("\n");

    }

}