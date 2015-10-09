/*
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Palindrome_Linked_List {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        int count=0;
        int len = 0;
        ListNode t=head;
        ListNode p = null;
        ListNode n = head.next;
        
        // finding the size of the linked list
        while(t!=null){
            count++;
            t=t.next;
        }
        len = count;
        count = 0;
        t = head;
        // Traverse to the midpoint and start reversing
        while(count < (len+1)/2) {
                t.next = p;
                p = t;
                t = n;
                if(n != null) {
                    n = n.next;
                    count++;
                }
        }
            
        if(len % 2 == 1) {
            n = p;
            p = p.next;
        }
        
        while(count < len) {
            if(t.val != p.val) {
                return false;
            }
            
            t = t.next;
            p = p.next;
            count++;
        }
        
        return true;
    }
}
