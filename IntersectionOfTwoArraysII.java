/*
Given two arrays, write a function to compute their intersection.
*/
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> rs = new ArrayList<Integer>();
        int i = 0; 
        int j = 0;
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                rs.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) 
                i++;
            else j++;
        }
        
        int[] result = new int[rs.size()];
        Iterator<Integer> iter = rs.iterator();
        for (int k = 0; k<result.length; k++) {
            result[k] = iter.next().intValue();
        }
        
        return result;
    }
}
