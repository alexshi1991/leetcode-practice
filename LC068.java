/*
 * Problem: https://leetcode.com/problems/text-justification/
 *
 * Idea:    1. greedy, pack as many words into current line as possible
 *          2. when a line can only fit one word, it should be left-justified
 *          3. the last line should be left-justified
 *          4. for all other lines: 
 *             a) calculate the # of extra spaces needed for padding
 *             b) calculate the # of space slots between words
 *             c) evenly distribute the extra spaces to these slots
 */


public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int wordsCount = words.length;
        List<String> result = new ArrayList<>();
        int curLen = 0; // total word length for current line
        int lastI = 0;  // index of the last word of the previous line
        for (int i = 0; i <= wordsCount; i++) {
            int numOfSpacesRequired = i - lastI;
            if (i == wordsCount || curLen + words[i].length() + numOfSpacesRequired > maxWidth) {
                // can not pack more words in the current line
                StringBuilder sb = new StringBuilder();
                int spaceCount = maxWidth - curLen;
                int spaceSlots = i - lastI - 1;
                if (spaceSlots == 0 || i == wordsCount) {
                    // if the current line can only fit one word or current line is the last line
                    // it should be left-justified, with no extra spaces between words
                    for (int j = lastI; j < i; j++){
                        sb.append(words[j]);
                        if(j != i - 1)
                            appendSpace(sb, 1); // only one space between words
                    }
                    appendSpace(sb, maxWidth - sb.length());                    
                } else {
                    // evenly distribute spaces between words
                    int spaceEach = spaceCount / spaceSlots;
                    int spaceExtra = spaceCount % spaceSlots;
                    for (int j = lastI; j < i; j++) {
                        sb.append(words[j]);
                        if (j != i - 1)
                            appendSpace(sb, spaceEach + (j - lastI < spaceExtra ? 1 : 0));
                    }                    
                }
                result.add(sb.toString());
                lastI = i;
                curLen = 0;
            }
            if (i < wordsCount)
                curLen += words[i].length();
        }
        return result;
    }
    
    private void appendSpace(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++)
            sb.append(' ');
    }
}
