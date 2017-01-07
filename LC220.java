/*
 * Problem:  https://leetcode.com/problems/contains-duplicate-iii/
 * 
 * Idea:     Solution 1: maintain a size-k TreeSet (an ordered Set), O(NlgK)
 *           Solution 2: bucket sort, O(N)
 *           
 */

public class Solution {

    // method 1: TreeSet, efficiently do range lookup (floor and ceiling)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        final TreeSet<Long> values = new TreeSet<>();
        for (int ind = 0; ind < nums.length; ind++) {
            Long floor = values.floor((long) nums[ind] + t);
            Long ceil = values.ceiling((long) nums[ind] - t);
            if ((floor != null && floor >= (long) nums[ind])
                    || (ceil != null && ceil <= (long) nums[ind])) {
                return true;
            }
            values.add((long) nums[ind]);
            if (ind >= k) {
                values.remove((long) nums[ind-k]);
            }
        }
        return false;        
    }

    // method 2: Bucket Sort, each bucket has size (t + 1)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                        || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                            return true;
            if (map.entrySet().size() >= k) {
                long expiredBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(expiredBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;        
    }

}
