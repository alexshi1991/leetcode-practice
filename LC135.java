/*
 * Problem:  https://leetcode.com/problems/candy/
 *
 * Idea:     two passes, left -> right && right -> left
 */


public class Solution {
    public int candy(int[] ratings) {
        int candies[] = new int[ratings.length];
        Arrays.fill(candies, 1); // give each child 1 candy
        
        // scan from left to right, make sure right higher rated child gets 1 more candy
        // than left lower rated child
        for (int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = (candies[i-1] + 1);
            }
        }
        
        // scan from right to left, make sure left higher rated child gets 1 more candy 
        // than right lower rated child
        for (int i = candies.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], (candies[i + 1] + 1));
            }
        }
        
        int sum = 0;
        for (int candy: candies)
            sum += candy;
        return sum;
    }
}
