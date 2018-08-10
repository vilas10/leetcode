/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode temp=head;
        ListNode temp1=temp.next;
        temp.next=null;
        temp=temp1;
        while(temp1!=null){
            temp1=temp.next;
            temp.next=head;
            head=temp;
            temp=temp1;
        }
        return head;
    }
}
