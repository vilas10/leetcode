/*
https://leetcode.com/problems/copy-list-with-random-pointer/description/
*/
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = null;
        RandomListNode curr = head;
        RandomListNode temp = null;
        
        while(curr != null) {
            if(newHead == null) {
                newHead = new RandomListNode(head.label);
                temp = newHead;
            } else {
                temp.next = new RandomListNode(curr.label);
                temp = temp.next;
            }
            
            map.put(curr, temp);
            
            curr = curr.next;
        }
        
        curr = head;
        temp = newHead;
        
        while(curr != null) {
            if(curr.random != null) {
                temp.random = map.get(curr.random);
            }
            
            temp = temp.next;
            curr = curr.next;
        }
        
        return newHead;
    }
}
