/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode t = head.next;
        ListNode p = head;
        
        while(t != null) {
            if(p.val == t.val) {
                p.next = t.next;
                t.next = null;
                t = p.next;
            } else {
                p = t;
                t = t.next;
            }
        }
        
        return head;
    }
}
