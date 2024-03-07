package Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day3 {
    public static void main(String[] args) {
        String file = "src/Day3/engine.txt";

        // Read the engine schematic from the text file
        char[][] schematic = readSchematicFromFile(file);

        // Calculate the sum of part numbers
        //int sum = calculatePartSum(schematic);

        // Print result
        //System.out.println("Answer: " + sum);
    }

    // Function to read the engine schematic from a text file
    public static char[][] readSchematicFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            // Read the dimensions of the schematic from the first line
            String[] dimensions = reader.readLine().split("\\s+");
            int rows = Integer.parseInt(dimensions[0]);
            int cols = Integer.parseInt(dimensions[1]);

            // Initialize the schematic array
            char[][] schematic = new char[rows][cols];

            // Read each line of the file and parse it into the schematic array
            for (int i = 0; i < rows; i++) {
                String line = reader.readLine();
                schematic[i] = line.toCharArray();
            }

            return schematic;
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }

    }

}
