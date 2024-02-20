package Day2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Day2B {
    public static void main(String[] args) {
        String inputFile = "src/Day2/gameinput.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line;
            int validGameSum = 0;
            while ((line = reader.readLine()) != null) {
                validGameSum += calcValidGames(line);
            }
            reader.close();
            System.out.println("The sum of valid game IDs is " + validGameSum);
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
        }
    }

    public static int calcValidGames(String line) {
        // Split the line by ":"
        String[] parts = line.split(":");
        int gameId = Integer.parseInt(parts[0].trim().split(" ")[1]); // Extract the game ID

        // Split the line by ";"
        String[] sets = parts[1].split(";");
        int redCount = 0, greenCount = 0, blueCount = 0;

        // Count the cubes of each color
        for (String set : sets) {
            String[] cubes = set.trim().split(",");
            for (String cube : cubes) {
                String[] info = cube.trim().split(" ");
                int count = Integer.parseInt(info[0].trim());
                String color = info[1].trim();
                if (color.equals("red")) {
                    redCount += count;
                } else if (color.equals("green")) {
                    greenCount += count;
                } else if (color.equals("blue")) {
                    blueCount += count;
                }
            }
        }

        System.out.println("Red: " + redCount);
        System.out.println("Blue: " + blueCount);
        System.out.println("Green: " + greenCount);

        // Check if the counts match the desired counts
        if (redCount <= 12 && greenCount <= 13 && blueCount <= 14) {
            return gameId; // Return the game ID if the counts match
        } else {
            return 0; // Return 0 if the counts don't match
        }
    }
}
