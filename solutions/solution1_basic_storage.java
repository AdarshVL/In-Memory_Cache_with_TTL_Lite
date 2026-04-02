import java.util.*;

/**
 * Solution 1: Basic Storage (SET & GET)
 * 
 * This program implements a simple in-memory cache using HashMap.
 * It supports:
 * - SET key value → store data
 * - GET key → retrieve data
 * 
 * Output is formatted in JSON-like structure.
 */

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // List to store results
        List<String> results = new ArrayList<>();

        // HashMap to act as cache
        Map<String, String> cache = new HashMap<>();

        // Read input line by line
        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();

            // Handle empty input line
            if (line.trim().isEmpty()) {
                results.add("{\"key\":[]}");
                continue;
            }

            // Split input into parts
            String[] parts = line.split(" ");
            String command = parts[0];

            // ------------------ SET COMMAND ------------------
            if (command.equals("SET")) {

                String key = parts[1];
                String value = parts[2];

                // Store key-value pair
                cache.put(key, value);

                results.add("{\"key\":[\"OK\"]}");
            }

            // ------------------ GET COMMAND ------------------
            else if (command.equals("GET")) {

                String key = parts[1];

                // Check if key exists
                if (cache.containsKey(key)) {
                    results.add("{\"key\":[\"" + cache.get(key) + "\"]}");
                } else {
                    results.add("{\"key\":[\"NULL\"]}");
                }
            }
        }

        // ------------------ PRINT OUTPUT ------------------
        System.out.print("[");

        for (int i = 0; i < results.size(); i++) {
            System.out.print(results.get(i));

            if (i < results.size() - 1) {
                System.out.print(",");
            }
        }

        System.out.println("]");
    }
}
