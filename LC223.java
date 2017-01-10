/*
 * Problem:  https://leetcode.com/problems/rectangle-area/
 *
 * Idea:     1. find out the area of the overlap area by obtaining the boundaries (comparing X and Y coordinates)
 *           2. total area = rect1 + rect2 - overlap
 *
 */

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int rect1 = (D-B) * (C-A);
        int rect2 = (H-F) * (G-E);
        
        int left = Math.max(A, E);
        int right = Math.min(G, C);
        int bottom = Math.max(F, B);
        int top = Math.min(D, H);
        int overlap = 0;
        if (right > left && top > bottom) {
            // there is overlap
            overlap = (right - left) * (top - bottom);
        }
        
        return rect1 + rect2 - overlap;
    }
}
