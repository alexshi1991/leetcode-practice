/*
 * Problem:  https://leetcode.com/problems/sliding-window-maximum/
 *
 * Idea:     priority queue  -- O(NlgK)
 *           deque (double-ended queue)   -- O(N)
 *
 */


public class Solution {
    // priority queue based approach, time complexity is O(NlgK)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                result[i-k] = pq.peek();
                pq.remove(nums[i-k]);
            }
            pq.add(nums[i]);
        }
        result[result.length-1] = pq.peek();  // last value
        return result;
    }
    
    // deque based approach (very hard to come up with), O(N) time
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int n = nums.length - k + 1;
        int[] result = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();  // deque stores indexes
        for (int i = 0; i < nums.length; i++) {
            // remove numbers out of range k
            while (!deque.isEmpty() && deque.getFirst() < i - k + 1) {
                deque.removeFirst();
            }
            // remove smaller numbers in k range as they are useless
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            // current max is first elem of deque
            if (i >= k - 1) {
                result[i-k+1] = nums[deque.getFirst()]; 
            }
        }
        return result;
    }
}
