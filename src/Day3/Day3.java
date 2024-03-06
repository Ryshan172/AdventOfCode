package Day3;

import java.io.BufferedReader;
import java.io.IOException;

public class Day3 {
    public static void main(String[] args) {
        String file = "src/Day2/engine.txt";

        // Read the engine schematic from the text file
        char[][] schematic = readSchematic(file);

        // Calculate the sum of part numbers
        //int sum = calculatePartSum(schematic);

        // Print result
        //System.out.println("Answer: " + sum);
    }

    public static char readSchematic(String file) {
        try (BufferedReader bufferedReader = new BufferedReader(file)) {

            // Read the dimensions of the schematic from the first line
            String[] dimensions = bufferedReader.readLine().split("//s+");
            int rows = Integer.parseInt(dimensions[0]);
            int cols = Integer.parseInt(dimensions[1]);

            // Initialise the schematic array
            char[][] schematicArray = new char[rows][cols];

            // Read each line of the file and pass it into the schematic array
            for (int i = 0; i < rows; i++) {
                String line = bufferedReader.readLine();
                schematicArray[i] = line.toCharArray();
            }

            return schematicArray;

        }
        catch (IOException e) {
            System.err.println("Could not read file " + e.getMessage());
            return null;
        }
    }


}
