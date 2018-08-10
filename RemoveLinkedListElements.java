/*
Remove all elements from a linked list of integers that have value val.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return head;
        }
        
        if(head.next == null && head.val == val) {
            head = null;
            return head;
        }
        
        ListNode n = head;
        ListNode t = null;
        
        while(n != null) {
            if(n.val == val) {
                if(t == null) {
                    t = n.next;
                    n.next = null;
                    n = t;
                    t = null;
                    head = n;
                } else {
                    t.next = n.next;
                    n.next = null;
                    n = t.next;
                }
            } else {
                t = n;
                n = n.next;
            }
        }
        
        return head;
    }
}
