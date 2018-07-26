/*
In a string S of lowercase letters, these letters form consecutive groups of the same character.

For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".

Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.

The final answer should be in lexicographic order.
*/
class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        char[] arr = S.toCharArray();
        int count = 1;
        
        List<List<Integer>> result = new ArrayList<>();
        
        int start = 0;
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] == arr[i]) {
                count++;
            } else {
                if (count >= 3) {
                    result.add(Arrays.asList(start, start + count - 1));                    
                }
                
                start = i;
                count = 1;
            }
        }
        
        if (count >= 3) {
            result.add(Arrays.asList(start, start + count - 1));                  
        }
        
        return result;
    }
}
