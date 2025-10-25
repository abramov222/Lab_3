import java.util.*;

class MapUtils {
    public static <K, V> Map<V, K> swapKeysAndValues(Map<K, V> original) {
        Map<V, K> swapped = new HashMap<>();
        for (Map.Entry<K, V> entry : original.entrySet()) {
            swapped.put(entry.getValue(), entry.getKey());
        }
        return swapped;
    }
    
    public static void main(String[] args) {
        Map<String, Integer> original = new HashMap<>();
        original.put("one", 1);
        original.put("two", 2);
        original.put("three", 3);
        
        Map<Integer, String> swapped = swapKeysAndValues(original);
        System.out.println("Original: " + original);
        System.out.println("Swapped: " + swapped);
    }
}