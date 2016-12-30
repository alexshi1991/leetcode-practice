/*
 * Problem:   https://leetcode.com/problems/compare-version-numbers/
 *
 * Idea:      Things to pay attention:
 *               1. "." character needs to be escaped if we want to split on it
 *               2. in this problem, a version string can contain arbitrary number of levels
 *               3. if a level does not contain a version number, default is 0
 *
 */

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1s = version1.split("\\.");
        String[] v2s = version2.split("\\.");
        
        int levels = Math.max(v1s.length, v2s.length);
        
        // compare versions at each level
        for (int i = 0; i < levels; i++) {
            Integer v1 = i < v1s.length ? Integer.parseInt(v1s[i]) : 0;
            Integer v2 = i < v2s.length ? Integer.parseInt(v2s[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) return compare;
        }
        
        return 0;
    }
}
