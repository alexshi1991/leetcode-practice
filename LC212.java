/*
 * Problem:  https://leetcode.com/problems/word-search-ii/
 *
 * Idea:     1. Trie + DFS backtracking
 *           2. use '#' to mark a board position as visited (instead of using extra space)
 *           3. store word at leaf TrieNodes
 */

public class Solution {
    
    private class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> res) {
        char c = board[i][j];
        if (c == '#' || node.next[c - 'a'] == null) return; // '#' means visited
        node = node.next[c - 'a'];
        if (node.word != null) {
            res.add(node.word); // found a new one
            node.word = null;   // avoid duplicate entries
        }
        board[i][j] = '#'; // mark it as currently being considered
        if (i > 0) dfs(board, i-1, j, node, res);
        if (j > 0) dfs(board, i, j-1, node, res);
        if (i < board.length - 1) dfs(board, i+1, j, node, res);
        if (j < board[0].length - 1) dfs(board, i, j+1, node, res);
        board[i][j] = c;   // unmark it
    } 
    
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode node = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (node.next[i] == null) {
                    node.next[i] = new TrieNode();
                }
                node = node.next[i];
            }
            node.word = w;
        }
        return root;
    }
}
