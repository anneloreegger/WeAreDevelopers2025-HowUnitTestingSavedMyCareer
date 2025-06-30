package wordfrequency.good;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordFrequencyTest {

    private final WordFrequency wf = new WordFrequency();

    @Test
    void cleanText() {
        // given
        String input = "Hello, world!";

        // when
        String output = wf.cleanText(input);

        // then
        assertEquals("hello world", output);
    }

    @Test
    void countWords() {
        // given
        String text = "hello world hello";

        // when
        Map<String, Integer> result = wf.countWords(text);

        // then
        assertEquals(2, result.get("hello"));
        assertEquals(1, result.get("world"));
    }

    @Test
    void testFullFlow() {
        // given
        String text = "Hello, world! Hello everyone. This is a test, a simple test.";

        // when
        String cleanedText = wf.cleanText(text);
        Map<String, Integer> wordCount = wf.countWords(cleanedText);

        // then
        // Expected cleaned text: "hello world hello everyone this is a test a simple test"
        assertEquals(2, wordCount.get("hello"));
        assertEquals(1, wordCount.get("world"));
    }
}
