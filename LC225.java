/*
 * Problem: https://leetcode.com/problems/implement-stack-using-queues/
 *
 * Idea:    1. make push() an O(N) cost operation, reverse the entire content of the queue
 *          2. pop(), top(), empty() are all O(1) operations
 * 
 */

class MyStack {
    private Queue<Integer> queue = new LinkedList<>();

    // O(N) reverse of queue
    public void push(int x) {
        queue.add(x);
        for (int i=1; i<queue.size(); i++)
            queue.add(queue.remove());
    }

    // O(1)
    public void pop() {
        queue.remove();
    }

    // O(1)
    public int top() {
        return queue.peek();
    }

    // O(1)
    public boolean empty() {
        return queue.isEmpty();
    }
}
