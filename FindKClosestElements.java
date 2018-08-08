/*
Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
*/
public class FindKClosestElements {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        ArrayList<Integer> newarr = new ArrayList<Integer>(arr);
        int left = 0;
        int right = newarr.size() - 1;
        int mid = 0;
        
        while (left < right) {
            mid = left + (right - left) / 2;
            int curr = newarr.get(mid).intValue();
            
            if (curr < x) left = mid + 1;
            else if (curr > x) right = mid - 1;
            else break;
        }
        
        int l = mid;
        int r = mid + 1;

        LinkedList<Integer> result = new LinkedList<Integer>();
        
        while (k-- > 0) {
            int ldiff = (l >= 0) ? Math.abs(x - newarr.get(l).intValue()) : Integer.MAX_VALUE;
            int rdiff = (r < newarr.size()) ? Math.abs(x - newarr.get(r).intValue()) : Integer.MAX_VALUE;    
            
            if (ldiff <= rdiff) {
                result.addFirst(newarr.get(l--));
            } else {
                result.addLast(newarr.get(r++));
            }    
        }
        
        return result;
    }
}
