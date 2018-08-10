/*
We are given head, the head node of a linked list containing unique integer values.

We are also given the list G, a subset of the values in the linked list.

Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class LinkedListComponents {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < G.length; i++) {
            set.add(G[i]);
        }
        
        int count = 0;
        boolean flag = false;
        
        while (head != null) {
            if (set.contains(head.val)) {
                if (!flag) {
                    flag = true;
                    count++;
                }
                set.remove(head.val);
            } else {
                flag = false;
            }
            
            head = head.next;
        }
        
        return count;
    }
}
