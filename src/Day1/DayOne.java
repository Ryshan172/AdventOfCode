package Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DayOne {

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
        int firstDigitIndex = -1;
        int lastDigitIndex = -1;

        //Find index of First and last digits

        for (int i =0; i < line.length(); i++) {
            char ch = line.charAt(i);
            // Finds index positions of first and last digits
            if (Character.isDigit(ch)) {
                // Check if it is the first digit encountered
                if (firstDigitIndex == -1) {
                    // Update the index to capture it
                    firstDigitIndex = i;
                }
                // Last digit index will always be the last digit encountered
                lastDigitIndex = i;
            }
        }

        if (firstDigitIndex == -1 || lastDigitIndex == -1) {
            return 0; // No digits found
        }

        // Extract first and last digits
        char firstChar = line.charAt(firstDigitIndex);
        char lastChar = line.charAt(lastDigitIndex);

        // Convert to integers
        int firstDigit = Character.getNumericValue(firstChar);
        int lastDigit = Character.getNumericValue(lastChar);

        // Combine - First digit is 10s
        int calibrationVal = (firstDigit * 10) + lastDigit;

        return  calibrationVal;
    }


}
