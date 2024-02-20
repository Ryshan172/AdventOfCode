package Year22;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class DayOne {

    /*
    Logic: Go through file, make breaks at each blank line.
    Each set then gets summed and added to a list.
    Get the Max value of the list
     */
    public static void main(String[] args) {

        String inputfile = "src/Year22/advent1.txt";


        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputfile));

            String line;
            List<Integer> currentSet = new ArrayList<>();
            List<Integer> allSums = new ArrayList<>();
            int sum = 0;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    // Calc the sum of the current set
                    for (int value : currentSet) {
                        sum += value;
                    }

                    //System.out.println("Sum of set " + sum);

                    // Add to Sums List
                    allSums.add(sum);

                    //reset sum and clear set
                    sum = 0;
                    currentSet.clear();
                }
                else {
                    // Parse the integer value and add it to the current set
                    int value = Integer.parseInt(line.trim());
                    currentSet.add(value);
                }
            }

            // Calculate sum of last set
            for (int value : currentSet) {
                sum += value;
            }

            // Print sum of last set
            //System.out.println("Sum of set: " + sum);

            // Add to Sums List
            allSums.add(sum);

            System.out.println(allSums);
            System.out.println(Collections.max(allSums));

        }
        catch (IOException e) {
            System.err.println("Error: Can't read file" + e.getMessage());
        }



    }
}
