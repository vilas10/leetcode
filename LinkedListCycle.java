/*
Given a linked list, determine if it has a cycle in it.

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
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        
        if(head==null || head.next==null || head.next.next==null || head.next.next.next==null){
            return false;
        }
        
       
        head=head.next;
        ListNode temp1=head.next.next;
        ListNode temp2=head.next.next.next;
    
    while(head!=temp2 && temp1!=temp2 && head!=temp1){
            
           if(temp2.next!=null && temp2.next.next!=null && temp2.next.next.next!=null)
                temp2=temp2.next.next.next;
            else
                return false;
                
            temp1=temp1.next.next;
            head=head.next;
        }
        
    return true;
    
        /*HashSet<ListNode> set=new HashSet<ListNode>();
        
        while(!set.contains(head)){
            if(head.next!=null){
            set.add(head);
            head=head.next;
            }else{
            return false;    
            }
        }
        */
     //   return true;
        
    }
    
}
