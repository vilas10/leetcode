/*
Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
*/
class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        Integer[] index = new Integer[nums.length];        
        
        for (int i = 0; i < index.length; i++) index[i] = i;
        Arrays.sort(index, (a, b) -> (nums[b] - nums[a]));
        
        String[] result = new String[nums.length];
                
        for (int i = 0; i < result.length; i++) {
            switch(i) {
                case 0: result[index[i]] = "Gold Medal"; break;
                case 1: result[index[i]] = "Silver Medal"; break;
                case 2: result[index[i]] = "Bronze Medal"; break;
                default: result[index[i]] = (i + 1) + "";
            }
        }
        
        return result;
    }
}
