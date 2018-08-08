/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */
 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConvertSortedListToBinarySearchTree {
    private ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        
        if(head == null) {
            return null;
        }
        
        ListNode temp = head;
        int size = 0;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        
        node = head;
        
        return sortedListToBST(0, size - 1);
    }
    
    TreeNode sortedListToBST(int start, int end) {
        if(start > end) {
            return null;
        }
        
        int mid = start + (end - start)/2;
        
        TreeNode left = sortedListToBST(start, mid - 1);
        
        TreeNode tnode = new TreeNode(node.val);
        tnode.left = left;
        node = node.next;
        
        tnode.right = sortedListToBST(mid + 1, end);
        
        return tnode;
    }
    
    TreeNode sortedListToBST(ListNode head, ListNode end) {
        if(head == null) {
            return null;
        }
        
        ListNode slowhead = head;
        ListNode fasthead = head;
        
        while(fasthead.next != end && fasthead.next.next != end) {
            slowhead = slowhead.next;
            fasthead = fasthead.next.next;
        }
        
        TreeNode mid = new TreeNode(slowhead.val);
         
        if(head != slowhead) {
            mid.left = sortedListToBST(head, slowhead);
        } 
        
        if(slowhead.next != end) {
            mid.right = sortedListToBST(slowhead.next, end);
        } 
        
        return mid;
    }
}
