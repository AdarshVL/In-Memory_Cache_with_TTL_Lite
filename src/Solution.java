import java.util.*;

/**
 * Final Solution: In-Memory Cache with TTL Lite
 * 
 * Features:
 * - SET (with TTL)
 * - GET
 * - DELETE
 * - STATS (hits & misses)
 * - PASS (time simulation)
 * - REPORT (sorted valid keys)
 */

public class Solution {

    // Node class to store value and expiry time
    static class Node {
        String value;
        long expiry;

        Node(String value, long expiry) {
            this.value = value;
            this.expiry = expiry;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> results = new ArrayList<>();
        Map<String, Node> cache = new HashMap<>();

        int hits = 0, misses = 0;
        long currentTime = 0;

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();

            // Handle empty line
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
                long ttl = Long.parseLong(parts[3]);

                long expiryTime = currentTime + ttl;
                cache.put(key, new Node(value, expiryTime));

                res = "OK";
            }

            // ------------------ GET ------------------
            else if (command.equals("GET")) {

                String key = parts[1];

                if (cache.containsKey(key)) {

                    Node node = cache.get(key);

                    // Check expiry
                    if (currentTime <= node.expiry) {
                        res = node.value;
                        hits++;
                    } else {
                        cache.remove(key); // expired
                        res = "NULL";
                        misses++;
                    }

                } else {
                    res = "NULL";
                    misses++;
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

            // ------------------ STATS ------------------
            else if (command.equals("STATS")) {

                res = "H:" + hits + " M:" + misses;
            }

            // ------------------ PASS ------------------
            else if (command.equals("PASS")) {

                long t = Long.parseLong(parts[1]);
                currentTime += t;

                res = "TIME_PASSED";
            }

            // ------------------ REPORT ------------------
            else if (command.equals("REPORT")) {

                List<String> validKeys = new ArrayList<>();

                for (Map.Entry<String, Node> entry : cache.entrySet()) {

                    String key = entry.getKey();
                    Node node = entry.getValue();

                    if (currentTime <= node.expiry) {
                        validKeys.add(key);
                    }
                }

                // Sort keys alphabetically
                Collections.sort(validKeys);

                // Format output
                res = "[" + String.join(",", validKeys) + "]";
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
