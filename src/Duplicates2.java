import java.util.HashMap;
import java.util.Map;

public class Duplicates2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 3, 2, 5, 5, 6, 6, 2, 4, 1};

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : arr) {
            // Put value with count or increment if exists
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        // Print only elements with more than 1 occurrence
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " : " + entry.getValue() + " times");
            }
        }
    }
}
