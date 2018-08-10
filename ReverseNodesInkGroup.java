/*
https://leetcode.com/problems/reverse-nodes-in-k-group/description/
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseNodesInkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        
        if(k == 0 || k == 1) {
            return head;
        }
        
        ListNode curr = head;
        ListNode first = head;
        ListNode last = head;
        ListNode prev = null;
        
        int count = 1;
        boolean flag = false;
        
        while(curr != null) {
            if(count == k) {
                if(!flag) {
                    head = last;
                    flag = true;
                }
                
                curr = curr.next;
                reverse(prev, first, last);
                prev = first;
                first = curr;
                last = curr;
                count = 1;
                continue;
            }
            
            last = last.next;
            //prev = curr;
            curr = curr.next;
            count++;
        }
        
        return head;
    }
    
    void reverse(ListNode prev, ListNode first, ListNode last) {

        ListNode temp = first.next;
        first.next = last.next;
        
        if(prev != null) {
            prev.next = last;
        }
        
        while(temp != last) {
            prev = first;
            first = temp;
            temp = temp.next;
            first.next = prev;
        }
        
        temp.next = first;
    }
}
