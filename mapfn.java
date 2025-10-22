import java.util.*;
public class mapfn {
        public static void main(String[] args) {

        // 1️⃣ Create and populate a HashMap
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 100);
        map.put("Banana", 60);
        map.put("Cherry", 120);

        System.out.println("Original Map: " + map);
        System.out.println("--------------------------------------------------");

        // 2️⃣ Using keySet() — view of all keys
        System.out.println("➡️ Using keySet():");
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println("Key: " + key);
        }

        // Removing a key using keySet() also removes it from the map
        keys.remove("Banana");
        System.out.println("After removing 'Banana' via keySet:");
        System.out.println("Map now: " + map);
        System.out.println("--------------------------------------------------");

        // 3️⃣ Using values() — view of all values
        System.out.println("➡️ Using values():");
        Collection<Integer> values = map.values();
        for (Integer val : values) {
            System.out.println("Value: " + val);
        }

        // Removing a value removes the corresponding entry from map
        values.remove(100);  // Removes entry with value 100 (i.e., Apple)
        System.out.println("After removing value 100 via values():");
        System.out.println("Map now: " + map);
        System.out.println("--------------------------------------------------");

        // 4️⃣ Using entrySet() — view of key-value pairs
        System.out.println("➡️ Using entrySet():");
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

        // Modify values directly using entrySet()
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getKey().equals("Cherry")) {
                entry.setValue(150);  // changes reflected in map
            }
        }
        System.out.println("After updating 'Cherry' value via entrySet:");
        System.out.println("Map now: " + map);
        System.out.println("--------------------------------------------------");

        // 5️⃣ Proving all are views (not copies)
        System.out.println("➡️ Modifying map directly:");
        map.put("Mango", 80);
        System.out.println("Map: " + map);
        System.out.println("keySet view: " + keys);
        System.out.println("values view: " + values);
        System.out.println("entrySet view: " + entries);
    }
}

