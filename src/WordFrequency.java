import java.util.*;

class WordFrequency {
    public static void main(String[] args) {
        String text = "The quick brown fox jumps over the lazy dog. The dog barks at the fox.";
        
        String[] words = text.toLowerCase().split("[^a-z]+");
        
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }
        
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}