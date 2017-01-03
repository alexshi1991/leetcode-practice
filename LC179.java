/*
 * Problem: https://leetcode.com/problems/largest-number/
 *
 * Idea:    1. create a custom comparator for comparing two number strs
 *          2. for example: for input "9", "92", we compare "992" and "929"
 *
 */

public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";

        // Convert int array to String array, so we can sort later on
        String[] strNums = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // custom comparator for two strings
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String str1 = s1 + s2;
                String str2 = s2 + s1;
                return str2.compareTo(str1);
            }
        };

        Arrays.sort(strNums, comp);
        
        // special edge case
        if (strNums[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String str : strNums) {
            sb.append(str);
        }

        return sb.toString();        
    }
}
