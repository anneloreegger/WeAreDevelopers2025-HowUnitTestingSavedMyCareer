package wordfrequency.good;

import java.util.HashMap;
import java.util.Map;

public class WordFrequency {

    public String cleanText(String text) {
        StringBuilder cleaned = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            // Allow only letters and spaces.
            if (Character.isLetter(c) || Character.isSpaceChar(c)) {
                cleaned.append(c);
            }
        }
        return cleaned.toString().toLowerCase();
    }

    public Map<String, Integer> countWords(String text) {
        String[] words = text.split("\\s+");
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }

    public void printWordCounts(Map<String, Integer> wordCount) {
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        WordFrequency wf = new WordFrequency();
        String text = "Hello, world! Hello everyone. This is a test, a simple test.";

        String cleanedText = wf.cleanText(text);
        Map<String, Integer> wordCount = wf.countWords(cleanedText);
        wf.printWordCounts(wordCount);
    }
}

