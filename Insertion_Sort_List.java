/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode t = head;
        ListNode n = head.next;
        ListNode p = null;
        ListNode pn = head;
        
        while(n != null) {
            while(n.val > t.val) {
                p = t;
                t = t.next;
            }
            if(t != n) {
                pn.next = n.next;
                if(t == head) {
                    n.next = t;
                    head = n;
                } else if (t == pn) {
                    p.next = n;
                    n.next = t;
                } else {
                    p.next = n;
                    n.next = t;
                }

                n = pn.next;
                
            } else {
                pn = n;
                n = n.next;
            }
            
            t = head;
            p = null;
        }
        
        return head;
    }
}
