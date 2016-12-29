/*
 * Problem:  https://leetcode.com/problems/maximum-product-subarray/
 *
 * Idea:     1. use two variables, min and max to keep track of the minimum(most negative) and maximum(most positive)
 *           2. scan the nums array and for every elem, update min and max, also update maxProduct
 *
 */

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
		int maxProduct = nums[0];
		// these two variables keep track of the minimum
		// product(most negative) and the maximum product
		// (most positive) so far
		int max = nums[0];
		int min = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int a = nums[i] * max;
			int b = nums[i] * min;
			max = Math.max(Math.max(a, b), nums[i]);
			min = Math.min(Math.min(a, b), nums[i]);
			maxProduct = Math.max(maxProduct, max);
		}
		return maxProduct;
    }
}
