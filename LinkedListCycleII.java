/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && slow != null) {
            slow = slow.next;
            if(slow == null) {
                return null;
            }
            
            if(fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            
            if(slow == fast) {
                break;
            }
        }
        
        if(slow != fast) {
            return null;
        }
        
        slow = head;
        
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}
