/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode part = null;
        ListNode partprev = null;
        
        while(curr != null) {
            if(curr.val >= x) {
                part = curr;
                partprev = prev;
                prev = curr;
                curr = curr.next;
                break;
            }
            
            prev = curr;
            curr = curr.next;
        }
        
        if(part == null) {
            return head;
        }
        
        while(curr != null) {
            if(curr.val < x) {
                prev.next = curr.next;
                curr.next = part;
                
                if(partprev != null) {
                    partprev.next = curr;
                } else {
                    head = curr;
                }
                
                partprev = curr;
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        
        return head;
    }
}
