/*
 * Problem:  https://leetcode.com/problems/add-and-search-word-data-structure-design/
 *
 * Idea:     1. similar to Trie Design
 *           2. use recursion for search(), because for '.' character
 *              we need to iterate (follow) all the non-null child links
 *
 */

public class WordDictionary {
    
    class TrieNode {
        
        private TrieNode[] links;
    
        private final int R = 26;
    
        private boolean isEnd;
    
        public TrieNode() {
            links = new TrieNode[R];
        }
    
        public boolean containsKey(char ch) {
            return links[ch -'a'] != null;
        }
        public TrieNode get(char ch) {
            return links[ch -'a'];
        }
        public void put(char ch, TrieNode node) {
            links[ch -'a'] = node;
        }
        public void setEnd() {
            isEnd = true;
        }
        public boolean isEnd() {
            return isEnd;
        }
    }
    
    private TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();        
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    // recursively match chars in array to nodes in the Trie
    private boolean match(char[] chars, int index, TrieNode node) {
        if (index == chars.length) return node.isEnd();
        char c = chars[index];
        if (c != '.') {
            return node.containsKey(c) && match(chars, index+1, node.get(c));
        } else {
            for (char child = 'a'; child <= 'z'; child++) {
                if (node.containsKey(child) 
                   && match(chars, index+1, node.get(child))) {
                       return true;
                }
            }
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
