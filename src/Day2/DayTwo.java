package Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DayTwo {

    public static void main(String[] args) {

        String inputFile = "src/Day2/gameinput.txt";

        try {

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line;

            int validGameSum = 0;

            // While there are lines to read
            while ((line = reader.readLine()) != null) {
                validGameSum += calcValidGames(line);
            }
            reader.close();

            System.out.println("The answer is " + validGameSum);

        }
        catch (IOException e) {
            System.err.println("Error reading input file" + e.getMessage());
        }

    }

    public static int calcValidGames(String line) {

        //Split line by ":"
        String[] parts = line.split(":");
        // Extract Game ID
        int gameId = Integer.parseInt(parts[0].trim().split(" ")[1]);

        // Split line by ";"
        String[] sets = line.split(";");
        int redCount = 0;
        int blueCount = 0;
        int greenCount = 0;

        //Count the cubes of each colour
        for (String set : sets) {
            String[] cubes = set.trim().split(",");

            for (String cube: cubes) {
                String[] info = cube.trim().split(" ");
                int count = Integer.parseInt(info[0].trim());
                String colour = info[1].trim();

                if (colour.equals("red")){
                    redCount += count;
                }
                else if (colour.equals("blue")) {
                    blueCount += count;

                }
                else if (colour.equals("green")) {
                    greenCount += count;
                }


            }


        }

        // Check if the counts match those for a valid game
        if (redCount == 12 && blueCount == 14 && greenCount == 13) {
            return gameId;
        }
        else {
            return 0;
        }

    }





}
