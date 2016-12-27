/*
 * Problem:  https://leetcode.com/problems/word-break-ii/
 *
 * Idea:     backtracking with memoization
 */

public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        String currSentence = new String();
        Set<String> impossibleStrs = new HashSet<>(); // memoization (remember prev search result)
        findSentence(s, 0, currSentence, result, wordDict, impossibleStrs);
        return result;
    }
    
    private void findSentence(String s, int start, String currSentence, List<String> result, Set<String> dict, Set<String> impossibleStrs) {
        if (start == s.length()) {
            result.add(currSentence.substring(1)); // remove leading space
        }
        
        // dfs
        for (int end = start + 1; end <= s.length(); end++) {
            if (dict.contains(s.substring(start, end)) && !impossibleStrs.contains(s.substring(end))) {
                currSentence += " " + s.substring(start, end);
                int sizeBefore = result.size();
                findSentence(s, end, currSentence, result, dict, impossibleStrs);
                int sizeAfter = result.size();
                if (sizeBefore == sizeAfter) {
                    impossibleStrs.add(s.substring(end));
                }
                int backtrackPos = currSentence.length() - currSentence.substring(start, end).length() - 1;
                currSentence = currSentence.substring(0, backtrackPos);
            }
        }
    }
}
