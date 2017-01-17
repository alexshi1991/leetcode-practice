/*
 * Problem:  https://leetcode.com/problems/find-the-duplicate-number/
 *
 * Idea:     1. binary search performed on search space
 *           2. consider input = {3, 4, 2, 5, 2, 1}, and we start out with search space [1,5]
 *           3. we retrieve mid point of search space (in this case 3)
 *           4. we scan the entire input array and count # of elem less than or equal to mid point (in this case 4 elem <= 3)
 *           5. if the count is greater than the mid point, then we shrink the search space to [low, mid]
 *           6. otherwise we shrink the search space to [mid+1, high]
 *
 */

public class Solution {
    public int findDuplicate(int[] nums) {
        int low = 1, high = nums.length - 1;
        int mid, count;
        while (low + 1 <= high) {
            count = 0;
            mid = low + (high - low) / 2;
            for (int n: nums) {
                if (n <= mid) count++;
            }
            if (count > mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
