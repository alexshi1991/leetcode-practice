/*
 * Problem: https://leetcode.com/problems/implement-queue-using-stacks/
 *
 * Idea:    1. use two stack, one for enqueue() operation, one for dequeue() operation
 *          2. when dequeue stack is empty, pop() all element from enqueue stack 
 *             and push them in reverse order to dequeue stack
 *
 */

class MyQueue {
    private Stack<Integer> enqueueStack;
    private Stack<Integer> dequeueStack;
    
    public MyQueue() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }
    
    // Push element x to the back of queue.
    public void push(int x) {
        enqueueStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        // if (empty()) throw new Exception("empty stack");
        
        // check if the dequeueStack is empty
        if (dequeueStack.isEmpty()) {
            // transfer all the elements in enqueueStack here
            transferBetweenStacks();
        }
        
        dequeueStack.pop();

    }

    // Get the front element.
    public int peek() {
        // if (empty()) throw new Exception("empty stack");
        
        if (dequeueStack.isEmpty()) {
            // transfer all the elements in enqueueStack here
            transferBetweenStacks();
        }

        return dequeueStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }
    
    // Transfer all the items in enqueueStack to dequeueStack
    private void transferBetweenStacks() {
        while (!enqueueStack.isEmpty()) {
            dequeueStack.push(enqueueStack.pop());
        }
    }
}
