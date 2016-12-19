/*
 * Problem:  https://leetcode.com/problems/gas-station/
 *
 * Idea:     1. Two observations:
 *              a) If start from gas station A can not reach gas station B,
 *                 then any station C in between also can not serve as a starting point,
 *                 B becomes the first station a trip from A can not reach,
 *                 consider B as starting point next
 *              b) If net gas is positive (total gas available - total gas consumption), 
 *                 then there must exists a solution
 *
 */

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int startingStation = 0;
        int sum = 0;    // sum from starting station
        int netGas = 0; // gas available - gas consumption
        for (int i = 0; i < gas.length; i++) {
            int gasDiff = gas[i] - cost[i];
            if (sum + gasDiff < 0) {
                startingStation = i + 1;
                sum = 0;
            } else {
                sum += gasDiff;
            }
            netGas += gasDiff;            
        }
        return netGas >= 0 ? startingStation : -1;
    }
}

