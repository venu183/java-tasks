import java.io.*;
import java.util.*;

class Printer {

    public <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}

public class Solution {
    public static void main(String[] args) {

        Printer myPrinter = new Printer();

        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};

        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna