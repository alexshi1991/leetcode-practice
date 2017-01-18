/*
 * Problem:  https://leetcode.com/problems/find-median-from-data-stream/
 *
 * Idea:     1. two heaps, one minHeap and one maxHeap
 *           2. always keep maxHeap.size() equal to or one greater than minHeap.size() (makes finding median easy)
 */

public class MedianFinder {
    
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    // Adds a number into the data structure.
    public void addNum(int num) {
        double median = findMedian();
        if (num <= median || maxHeap.isEmpty()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        rebalance(minHeap, maxHeap);
    }
    
    // rebalance operation to make sure that maxHeap size is always equal to or one greater than minHeap size 
    private void rebalance(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        } else if (maxHeap.size() > minHeap.size() + 1) { // maxHeap has two more item
            minHeap.add(maxHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        
        if (maxHeap.size() == 0)  return 0;
        
        // size of maxHeap is always equal to or one more than minHeap
        // which makes finding median relatively easy
        double median = 0;
        if (minHeap.size() == maxHeap.size()) {
            median = (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            median = (double) maxHeap.peek();
        }
        return median;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
