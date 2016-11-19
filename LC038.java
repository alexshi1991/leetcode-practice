/*
 * Problem: https://leetcode.com/problems/count-and-say/
 *
 * Idea: 1. generate a new string using the previous one
 *       2. important not to forget the last 'count and say'
 *       3. StringBuilder for efficiency
 */




public class Solution {
    public String countAndSay(int n) {
        String str = "1";
        StringBuilder sb = new StringBuilder();
        while (n > 1) {
            sb.setLength(0);
            char curr = str.charAt(0);
            int count = 1;
            for (int i = 1; i < str.length(); i++) {
                char c = str.charAt(i);
                if (curr != c) {
                    sb.append(count);
                    sb.append(curr);
                    curr = c;
                    count = 1;
                } else {
                    count++;
                }
            }
            sb.append(count);  // important: don't forget the last one
            sb.append(curr);
            str = sb.toString();
            n--;
        }
        return str;
    }
}
