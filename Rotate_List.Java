/*
https://leetcode.com/problems/rotate-list/description/
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0 || head.next == null) {
            return head;
        }
        
        int len = 1;
        int k1 = 1;
        
        ListNode front = head;
        ListNode back = head;
        //ListNode prev = null;
        
        while(front.next != null) {
            len++;
            front = front.next;
        }
        
        for(k1 = len - k%len; k1 > 1; k1--) {
            back = back.next;
        }
        
        front.next = head;
        head = back.next;
        back.next = null;
        
        return head;
    }
}
