package org.howard.edu.lsp.midterm.question4;

import java.util.ArrayList;
import java.util.List;

/**
 * Processes a sentence to find all the longest words.
 */
public class WordProcessor {
    private String sentence; // The sentence to be processed

    /**
     * Constructs a WordProcessor with the specified sentence.
     *
     * @param sentence the sentence to process
     */
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Finds all the longest words in the sentence.
     * Words are split based on one or more whitespace characters.
     *
     * @return a list of the longest words in their original order;
     *         returns an empty list if the sentence is empty or contains no words
     */
    public List<String> findLongestWords() {
        List<String> result = new ArrayList<>();
        if (sentence == null || sentence.trim().isEmpty()) {
            return result;
        }
        String[] words = sentence.trim().split("\\s+");
        int maxLen = 0;
        // Determine the maximum word length
        for (String word : words) {
            if (word.length() > maxLen) {
                maxLen = word.length();
            }
        }
        // Add all words with length equal to maxLen
        for (String word : words) {
            if (word.length() == maxLen) {
                result.add(word);
            }
        }
        return result;
    }
}
