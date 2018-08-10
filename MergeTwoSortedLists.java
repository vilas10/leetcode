/*
Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode head;
        ListNode result;
        int count=0;
        
        if(l1==null && l2==null){
            return null;
        }else if(l1==null && l2!=null){
            return l2;
        }else if(l1!=null && l2==null){
            return l1;
        }
        
        if(l1.val>l2.val){
                result=new ListNode(l2.val);
                l2=l2.next;
            }else{
                result=new ListNode(l1.val);
                l1=l1.next;
        }
        
        head=result;
        
        while(l1!=null && l2!=null){
            if(l1.val>l2.val){
                result.next=new ListNode(l2.val);
                result=result.next;
                l2=l2.next;
            }else{
                result.next=new ListNode(l1.val);
                result=result.next;
                l1=l1.next;
            }
        }
        
        while(l1!=null){
            result.next=new ListNode(l1.val);
            result=result.next;
            l1=l1.next;
        }
        
        while(l2!=null){
            result.next=new ListNode(l2.val);
            result=result.next;
            l2=l2.next;
        }
        
        return head;
    }
}
