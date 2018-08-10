/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
        return head;
        int count = 0;
        
        if(n <= 0) {
            return null;
        }
        
        ListNode t = head;
        ListNode t1 = null;
        ListNode t2 = t;
        
        while(t2 != null) {
            t2 = t2.next;
            if(count >= n) {
                t1 = t;
                t = t.next;
            }
            count++;
        }
        
        // Removing the node
        if(t1 == null) {
            head = head.next;
        } else {
            t1.next = t.next;
        }
        
        return head;
    }
}
