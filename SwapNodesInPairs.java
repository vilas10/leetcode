/*
Given a linked list, swap every two adjacent nodes and return its head.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        
        // Initialization
        ListNode temp1 = null;
        ListNode temp2 = null;
        ListNode n = null;
  
        if(head != null && head.next == null) {
            return head;
        }
        
        while(head !=null && head.next != null){
            if (temp1 != null) {
                temp1.next.next = head.next;
            }
            
            temp1 = head.next;
            head.next = head.next.next;
            temp1.next = head;
            if(temp2 == null) {
                temp2 = temp1;
            }
            head = head.next;
        }
        
        return temp2;
        
/*        if(t == null) {
//            return head;
        }
        // If only two nodes
        if(t.next == null) {
            t.next = p;
            p.next = null;
            head = t;
            return head;
        }
        head = t;
        n = t.next;
        // If more than two nodes
        do {
            //n = t.next.next.next;
            if(n.next != null) {
                p.next = n.next;
                t.next = p;
                p = n;
                t = n.next;
                n = n.next.next;
                t.next = p;
            } else {
                p.next = n;
                t.next = p;
                p = n;
                t = n.next;
            }
                
        } while(n != null && n.next != null);
        
        return head;
*/    }
}
