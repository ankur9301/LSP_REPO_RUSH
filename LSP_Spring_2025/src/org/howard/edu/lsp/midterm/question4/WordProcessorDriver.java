package org.howard.edu.lsp.midterm.question4;

import java.util.List;

/**
 * Driver class for testing the WordProcessor.
 */
public class WordProcessorDriver {
    public static void main(String[] args) {
        // Test case: Sentence with a single longest word
        WordProcessor wp1 = new WordProcessor("This is a test with amazing achievements");
        List<String> longestWords1 = wp1.findLongestWords();
        System.out.println("Longest words: " + longestWords1);

        // Test case: Sentence with multiple longest words
        WordProcessor wp2 = new WordProcessor("Java is a powerful tool");
        List<String> longestWords2 = wp2.findLongestWords();
        System.out.println("Longest words: " + longestWords2);

        // Test case: Sentence with single character words
        WordProcessor wp3 = new WordProcessor("A B C D E");
        List<String> longestWords3 = wp3.findLongestWords();
        System.out.println("Longest words: " + longestWords3);

        // Test case: Empty string input
        WordProcessor wp4 = new WordProcessor("");
        List<String> longestWords4 = wp4.findLongestWords();
        System.out.println("Longest words: " + longestWords4);
    }
}
