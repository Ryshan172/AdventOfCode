package Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DayOnePartB {

    // Map to store mappings of spelled-out numbers to digits
    private static final Map<String,Integer> spelledOutNumbers = new HashMap<>();

    static {
        // Initialize the map with the mappings of spelled out nums
        spelledOutNumbers.put("zero", 0);
        spelledOutNumbers.put("one", 1);
        spelledOutNumbers.put("two", 2);
        spelledOutNumbers.put("three", 3);
        spelledOutNumbers.put("four", 4);
        spelledOutNumbers.put("five", 5);
        spelledOutNumbers.put("six", 6);
        spelledOutNumbers.put("seven", 7);
        spelledOutNumbers.put("eight", 8);
        spelledOutNumbers.put("nine", 9);
    }

    public static void main(String[] args) {

        String inputFile = "src/Day1/input.txt";


        try{
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            String line;
            int sum = 0;

            while((line = reader.readLine()) != null) {
                sum += extractCalibrationVal(line);
            }
            reader.close();

            System.out.println("Sum of all calibration values: " + sum);
        }
        catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
        }


    }

    public static int extractCalibrationVal(String line) {
        // Convert the line to lowercase to simplify comparison
        line = line.toLowerCase();

        // Initialize variables to store first and last digits
        int firstDigit = -1;
        int lastDigit = -1;

        // Iterate through the map entries to find all possible combinations of spelled-out numbers
        for (Map.Entry<String, Integer> entry : spelledOutNumbers.entrySet()) {
            String spelledOut = entry.getKey();
            int digit = entry.getValue();

            int startIndex = 0;
            int index;
            while ((index = line.indexOf(spelledOut, startIndex)) != -1) {
                // Check if the spelled-out number overlaps with the first digit
                if (firstDigit == -1 || index < firstDigit) {
                    firstDigit = index;
                }

                // Check if the spelled-out number overlaps with the last digit
                if (index + spelledOut.length() > lastDigit) {
                    lastDigit = index + spelledOut.length();
                }

                startIndex = index + 1; // Move to the next character after the current match
            }
        }

        // If both first and last digits are found, extract and return the calibration value
        if (firstDigit != -1 && lastDigit != -1) {
            // Extract the first and last digits from the line
            String firstDigitStr = line.substring(firstDigit, firstDigit + 1);
            String lastDigitStr = line.substring(lastDigit - 1, lastDigit);
            int first = spelledOutNumbers.getOrDefault(firstDigitStr, -1); // Handle null value with -1
            int last = spelledOutNumbers.getOrDefault(lastDigitStr, -1); // Handle null value with -1
            if (first != -1 && last != -1) {
                return first * 10 + last;
            }
        }

        return 0; // Return 0 if first or last digit is not found
    }
}
