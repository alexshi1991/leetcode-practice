/*
 * Problem:   https://leetcode.com/problems/maximum-gap/
 *
 * Idea:      1. bucket sort
 *            2. get the max and min value of the array, allocate buckets for different ranges
 *            3. scan the input nums array, update minBucket and maxBucket for each range
 *            4. find the max gap by examining min and max value for each range
 *
 */

public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        // get the max and min value of the array
        int min = nums[0];
        int max = nums[0];
        for (int i:nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        // the minimum possible gap, ceiling of the integer division
        int gap = (int)Math.ceil((double)(max - min)/(nums.length - 1));
        int[] bucketsMIN = new int[nums.length - 1]; // store the min value in that bucket
        int[] bucketsMAX = new int[nums.length - 1]; // store the max value in that bucket
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
        // put numbers into buckets
        for (int i:nums) {
            if (i == min || i == max)
                continue;
            int idx = (i - min) / gap; // bucket index
            bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]);
            bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]);
        }
        // scan the buckets for the max gap
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < nums.length - 1; i++) {
            if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE)
                // empty bucket
                continue;
            // min value minus the previous value is the current gap
            maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
            // update previous bucket value
            previous = bucketsMAX[i];
        }
        maxGap = Math.max(maxGap, max - previous); // updata the final max value gap
        return maxGap;        
    }
}
