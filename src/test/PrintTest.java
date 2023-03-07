package test;

import main.Print;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;


class PrintTest {

    String actualString;
    String expectedString;
    int[] actualArray;
    String expectedArray;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    HashMap frequencyArray;
    String expectedGraph;
    int min;
    int max;
    int maxFrequency;
    String expectedFrequency;


    @BeforeEach
    public void setup(){
        actualString = "Test string";
        expectedString = "[0;1mTest string";
        actualArray = new int[] {1, 2, 3, 4, 5};
        expectedArray = "[0;1m  1\u001B[0;1m  2\u001B[0;1m  3\u001B[0;1m  4\u001B[0;1m  5";
        System.setOut(new PrintStream(outputStreamCaptor));
        frequencyArray = new HashMap();
        expectedGraph = "[0;1m  *\u001B[0;1m  *\u001B[0;1m  *\u001B[0;1m  *\n\u001B[0;1m  1\u001B[0;1m  2\u001B[0;1m  3\u001B[0;1m  4";
        min = 1;
        max = 4;
        maxFrequency = 1;
        expectedFrequency = "[1;34m\n\nFrequency: \u001B[0;1m  1\u001B[0;1m  0\u001B[0;1m  1\u001B[0;1m  0\u001B[0m\n" +
                            "\u001B[1;34mNumber:    \u001B[0;1m  1\u001B[0;1m  2\u001B[0;1m  3\u001B[0;1m  4";
    }


    @Test
    void printGreetingMessage() {
        Print.printGreetingMessage();
    }


    @Test
    void printString() {
        Print.printString(actualString);
        assertEquals(expectedString, outputStreamCaptor.toString().trim());
    }


    @Test
    void printArray() {
        Print.printArray(actualArray);
        assertEquals(expectedArray, outputStreamCaptor.toString().trim());
    }


    @Test
    void printFrequency() { //  Contents are identical
        frequencyArray.put(1, 1);
        frequencyArray.put(2, 0);
        frequencyArray.put(3, 1);
        frequencyArray.put(4, 0);

        Print.printFrequency(frequencyArray, min, max);
        assertEquals(expectedFrequency, outputStreamCaptor.toString().trim());
    }


    @Test
    void printGraph() {     //  Expected and actual looks the same.
        frequencyArray.put(1, 1);
        frequencyArray.put(2, 1);
        frequencyArray.put(3, 1);
        frequencyArray.put(4, 1);

        Print.printGraph(frequencyArray, maxFrequency, min, max);
        assertEquals(expectedGraph, outputStreamCaptor.toString().trim());
    }

}