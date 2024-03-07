package Year22;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day3 {

    public static void main(String[] args) {

        String inputfile = "src/Year22/rucksack.txt";

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputfile));

            String line;
            // Initialise count
            int prioritySum = 0;

            while((line = bufferedReader.readLine()) != null) {
                // Divide each line by half
                int halfLength = line.length() / 2;

                // Create a map of lowercase characters
                Map<Character,Integer> lowercasePriorities = createLowercasePriorities();
                // Map of Uppercase Priorities
                Map<Character,Integer> uppercasePriorities = createUppercasePriorities();

                // Map of first half of characters in the line
                Map<Character, Boolean> firstHalfLetters = new HashMap<>();
                for (int i = 0; i < halfLength; i++) {
                    char letter = line.charAt(i);
                    firstHalfLetters.put(letter, true);
                }

                // Go through each letter of the second half and see if it is found in the first
                for (int i = halfLength; i < line.length(); i++) {
                    char letter = line.charAt(i);

                    if (firstHalfLetters.containsKey(letter)) {
                        /*
                        Check if letter if found in both compartments
                        retrieves the priority of the current letter based on whether it is lowercase or uppercase.
                         */
                        int priority = Character.isLowerCase(letter) ?
                                lowercasePriorities.get(letter) : uppercasePriorities.get(letter);
                        prioritySum += priority;
                    }

                }


            }

            // Return the result
            System.out.println("Sum of priorities: " + prioritySum);
            bufferedReader.close();


        }
        catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Create map of Lowercase character priorities
    public static Map<Character, Integer> createLowercasePriorities() {
        Map<Character, Integer> priorites = new HashMap<>();

        for (char c = 'a'; c <= 'z'; c++) {
            priorites.put(c, c - 'a' + 1);
        }

        return priorites;
    }


    // Create a map of Uppercase priorities
    public static Map<Character, Integer> createUppercasePriorities() {
        Map<Character, Integer> priorites = new HashMap<>();

        for (char c = 'A'; c <= 'Z'; c++) {
            priorites.put(c, c - 'A' + 26);
        }

        return priorites;
    }



}
