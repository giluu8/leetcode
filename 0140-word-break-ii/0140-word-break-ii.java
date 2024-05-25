import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

// Trie data structure for efficient word storage and retrieval
class TrieNode {
    // Array representing the children of each node
    TrieNode[] children = new TrieNode[26];
    // Flag to indicate the end of a word
    boolean isEndOfWord;

    // Method to insert a word into the trie
    void insert(String word) {
        TrieNode currentNode = this;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index];
        }
        currentNode.isEndOfWord = true;
    }

    // Method to search for a word in the trie
    boolean search(String word) {
        TrieNode currentNode = this;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (currentNode.children[index] == null) {
                return false;
            }
            currentNode = currentNode.children[index];
        }
        return currentNode.isEndOfWord;
    }
}

public class Solution {
    // Create a root trie node
    private TrieNode rootTrieNode = new TrieNode();

    // Main method to find all possible word breaks
    public List<String> wordBreak(String s, List<String> wordDict) {
        // Insert all words from the dictionary into the trie
        for (String word : wordDict) {
            rootTrieNode.insert(word);
        }
      
        // Perform a depth-first search to find all combinations
        List<List<String>> combinations = depthFirstSearch(s);
        // Convert lists of strings into space-separated sentences
        return combinations.stream()
                           .map(words -> String.join(" ", words))
                           .collect(Collectors.toList());
    }

    // Method for depth-first search to find word break combinations
    private List<List<String>> depthFirstSearch(String s) {
        List<List<String>> results = new ArrayList<>();
        // If the string is empty, add an empty list (base case)
        if ("".equals(s)) {
            results.add(new ArrayList<>());
            return results;
        }

        // Try breaking the string at different points to find valid words
        for (int i = 1; i <= s.length(); ++i) {
            // Check if the prefix is a valid word
            if (rootTrieNode.search(s.substring(0, i))) {
                // Recursively process the remaining string
                for (List<String> suffixCombination : depthFirstSearch(s.substring(i))) {
                    // Add the valid word to the beginning of the list
                    suffixCombination.add(0, s.substring(0, i));
                    // Add the new combination to the results
                    results.add(suffixCombination);
                }
            }
        }
        return results;
    }
}