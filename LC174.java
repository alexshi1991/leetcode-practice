/*
 * Problem:  https://leetcode.com/problems/dungeon-game/
 *
 * Idea:     1. dynamic programming, initialize health[m][n]
 *           2. calculate the minimum health required to reach each room
 *           3. start from the bottom right and make our way to the top left room
 *           4. for each room calculates the minimum health required to go right and go down, 
 *              and get the minimum of the two
 *           5. the result is at top left room, health[0][0]
 *
 */

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        int[][] health = new int[m][n];
        
        health[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);
        
        for (int i = m - 2; i >= 0; i--) {            
            health[i][n - 1] = Math.max(health[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }
        
        for (int j = n - 2; j >= 0; j--) {
            health[m - 1][j] = Math.max(health[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }
        
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(health[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(health[i][j + 1] - dungeon[i][j], 1);
                health[i][j] = Math.min(right, down);
            }
        }
        
        return health[0][0];        
    }
}
