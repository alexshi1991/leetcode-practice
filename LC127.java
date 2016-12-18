/*
 * Problem: https://leetcode.com/problems/word-ladder/
 *
 * Idea:    BFS, use a queue:
 *              a) find all dict words that are 1-distance away from beginWord
 *              b) and then find all dict words that are 1-distance away to those words
 */

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (wordList == null || !wordList.contains(beginWord) || !wordList.contains(endWord)) {
            return 0;
        }
        
        Set<String> wordListCopy = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        
        queue.add(beginWord);
        wordListCopy.remove(beginWord);
        int length = 1;
        
        // BFS
        while(!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                String current = queue.remove();
                // find all the words that are only 1-distance away
                for (int j = 0; j < current.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (current.charAt(j) == c) {
                            continue;
                        }
                        // replace char at index j with c
                        String nextWord = replaceChar(current, j, c);
                        if (nextWord.equals(endWord)) {
                            return length + 1;
                        } else if (wordListCopy.contains(nextWord)){
                            // add on to the queue and remove entry from wordListCopy
                            queue.add(nextWord);
                            wordListCopy.remove(nextWord);
                        }
                    }
                }
            }
            length++;
        }
        return 0;
    }
    
    // replace char at str[index] with a different char
    private String replaceChar(String str, int index, char c) {
        char[] strArr = str.toCharArray();
        strArr[index] = c;
        return String.valueOf(strArr);
    }
}
