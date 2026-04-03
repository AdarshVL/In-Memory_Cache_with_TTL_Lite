import java.util.*;

/**
 * Solution 2: Data Management (SET, GET, DELETE)
 * 
 * This program extends the basic cache by adding DELETE functionality.
 * It supports:
 * - SET key value → store data
 * - GET key → retrieve data
 * - DELETE key → remove data
 */

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> results = new ArrayList<>();
        Map<String, String> cache = new HashMap<>();

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();

            if (line.trim().isEmpty()) {
                results.add("{\"key\":[]}");
                continue;
            }

            String[] parts = line.split(" ");
            String command = parts[0];
            String res = "";

            // ------------------ SET ------------------
            if (command.equals("SET")) {

                String key = parts[1];
                String value = parts[2];

                cache.put(key, value);
                res = "OK";
            }

            // ------------------ GET ------------------
            else if (command.equals("GET")) {

                String key = parts[1];

                if (cache.containsKey(key)) {
                    res = cache.get(key);
                } else {
                    res = "NULL";
                }
            }

            // ------------------ DELETE ------------------
            else if (command.equals("DELETE")) {

                String key = parts[1];

                if (cache.containsKey(key)) {
                    cache.remove(key);
                    res = "DELETED";
                } else {
                    res = "NOT_FOUND";
                }
            }

            // Escape output for JSON format
            String escaped = res.replace("\\", "\\\\").replace("\"", "\\\"");
            results.add("{\"key\":[\"" + escaped + "\"]}");
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
