package wordfrequency.bad;

import java.util.HashMap;
import java.util.Map;

public class WordFrequency {
    public static void main(String[] args) {
        String text = "Hello, world! Hello everyone. This is a test, a simple test.";

        // Manually clean text: remove punctuation by keeping only letters and spaces.
        StringBuilder cleaned = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c) || Character.isSpaceChar(c)) {
                cleaned.append(c);
            }
        }
        String cleanedText = cleaned.toString().toLowerCase();

        // Split the cleaned text into words and count them.
        String[] words = cleanedText.split("\\s+");
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty()) {
                continue; // Skip any extra spaces.
            }
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Print the word counts.
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

