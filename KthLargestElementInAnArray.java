/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
*/
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int i=0; i<nums.length; i++) {
            pq.offer(nums[i]);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        
        return pq.peek();
    }
}
