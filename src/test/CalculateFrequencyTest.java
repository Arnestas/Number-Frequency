package test;
import main.CalculateFrequency;
import org.junit.jupiter.api.BeforeEach;
import java.util.Arrays;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

class CalculateFrequencyTest {
    HashMap<Integer, Integer> frequencyArray = new HashMap<>();
    int[] actual;
    String[] stringActual;
    String input;
    int[] expected;
    int[] expectedWrong;
    int min;
    int max;


    @BeforeEach
    public void setup(){
        actual = new int[] {1, 4, 1, 5, 8, 1, 3, 5, 1, 4, 1, 3, 7, 2};
        stringActual = new String[] {"1", "4", "1", "5", "8", "1", "3", "5", "1", "4", "1", "3", "7", "2", "a"};
        input = "1 4 1 5 8 1 3 5 1 4 1 3 7 2";
        expected = new int[] {1, 4, 1, 5, 8, 1, 3, 5, 1, 4, 1, 3, 7, 2};
        expectedWrong = new int[] {2, 4, 1, 5, 8, 1, 3, 5, 1, 4, 1, 3, 7, 2};
        min = 1;
        max = 8;
    }


    @org.junit.jupiter.api.Test
    void enterStringOfIntegers() {
    }


    @org.junit.jupiter.api.Test
    void validateUserInput() {
        assertArrayEquals(expected, CalculateFrequency.validateUserInput(stringActual));
        assertNotEquals(Arrays.toString(expectedWrong), Arrays.toString(CalculateFrequency.validateUserInput(stringActual)));
    }


    @org.junit.jupiter.api.Test
    void calculateFrequency() {

        frequencyArray.put(1, 5);
        frequencyArray.put(2, 1);
        frequencyArray.put(3, 2);
        frequencyArray.put(4, 2);
        frequencyArray.put(5, 2);
        frequencyArray.put(6, 0);
        frequencyArray.put(7, 1);
        frequencyArray.put(8, 1);

        assertEquals(frequencyArray, CalculateFrequency.calculateFrequency(actual, min, max), "Testing with correct data");

        frequencyArray.put(8, 2);   //  wrong value
        assertNotEquals(frequencyArray, CalculateFrequency.calculateFrequency(actual, min, max), "Testing with wrong data");
    }

}