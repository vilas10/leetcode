/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        
        ListNode prev = null;
        ListNode curr = head;
        int count = 0;
        while(curr != null) {
            
            while(curr.next != null && curr.val == curr.next.val) {
                count++;
                curr = curr.next;
            } 
            
            if(count > 0) {
                if(prev == null) {
                    head = curr.next;
                    curr.next = null;
                    curr = head;
                } else {
                    prev.next = curr.next;
                    curr.next = null;
                    curr = prev.next;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
            
            count = 0;
        }
        
        return head;
    }
}
