/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {


    /*
     * Problem: https://leetcode.com/problems/add-two-numbers/
     * 
     * Idea: add numbers digit-by-digit and dynamically append new linked list node as needed
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead = null, resultTail = null;
        ListNode num1 = l1, num2 = l2;
        int carryover = 0, sum = 0;
        ListNode newNode = null;
        while (l1 != null || l2 != null || carryover != 0) {
            sum = carryover;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            newNode = new ListNode(sum % 10); // new node
            carryover = sum / 10;
            
            // append new node to result
            if (resultHead == null) {
                resultHead = newNode;
                resultTail = resultHead;
            } else {
                resultTail.next = newNode;
                resultTail = newNode;
            }
        }
        return resultHead;
    }
}
