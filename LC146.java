/*
 * Problem:  https://leetcode.com/problems/lru-cache/
 *
 * Idea:     1. Use a doubly-linked list as auxiliary data structure,
 *              most recently accessed item is the head of the list, least recently used is the last node
 *           2. Whenever a get() or set() is called on existing keys, moved the node to the front
 *           3. Whenever a set() is called on new keys, and cache has reached capacity,
 *              invoke eviction policy (LRU), remove last node
 */

public class LRUCache {
    
    // doubly-linked list
    class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    private ListNode head, tail;
    private Map<Integer, ListNode> map;
    private int capacity;
    private int size;
    
    public LRUCache(int capacity) {
        map = new HashMap<Integer, ListNode>();
        this.capacity = capacity;
        head = new ListNode(0,0);
        tail = new ListNode(0,0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    
    public int get(int key) {
        ListNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        
        // remove node
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
        // move to the front
        moveToFront(node);
        
        return node.val;
    }
    
    public void set(int key, int value) {
        // search for key in the map
        ListNode node = map.get(key);
        if (node != null) {
            node.val = value;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            moveToFront(node);
        } else {
            // check for need of eviction
            if (size == capacity) {
                ListNode removed = removeFromEnd();
                map.remove(removed.key);
            } else {
                size++;
            }
            ListNode added = new ListNode(key, value);
            moveToFront(added);
            map.put(key, added);
        }
    }
    
    // helpers
    private void moveToFront(ListNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    private ListNode removeFromEnd() {
        ListNode node = tail.prev;
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        return node;
    }
}
