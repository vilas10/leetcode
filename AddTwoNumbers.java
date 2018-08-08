/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode sum = null;
        ListNode head = null;
        int temp=0;
        
        while(l1!=null && l2!=null){
            
            if(sum == null) {
                sum = new ListNode(0);
                head = sum;
            } else {
                sum.next = new ListNode(0);
                sum = sum.next;
            }
            temp=l1.val+l2.val+temp;
            sum.val=temp%10;
            temp=temp/10;
            l1=l1.next;
            l2=l2.next;
        }
        
        if(l1==null){
            while(l2!=null){
                if(sum == null) {
                sum = new ListNode(0);
                head = sum;
            } else {
                sum.next = new ListNode(0);
                sum = sum.next;
            }
                temp=l2.val+temp;
                sum.val=temp%10;
                temp=temp/10;
                l2=l2.next;
            }
        }
        
        if(l2==null){
            while(l1!=null){
                if(sum == null) {
                sum = new ListNode(0);
                head = sum;
            } else {
                sum.next = new ListNode(0);
                sum = sum.next;
            }
            temp=l1.val+temp;
                sum.val=temp%10;
                temp=temp/10;
                l1=l1.next;
            }
        }
        
        if(temp!=0){
            if(sum == null) {
                sum = new ListNode(0);
                head = sum;
            } else {
                sum.next = new ListNode(temp);
                sum = sum.next;
            }
        }
        
        return head;
    }
}
