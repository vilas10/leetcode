/*
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
*/
class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i1 = 0, i2 = 0;

        for (i1 = 0; i1 < numbers.length - 1; i1++) {
            if (i1 != 0 && numbers[i1] == numbers[i1 - 1]) {
                continue;
            }
            for (i2 = i1 + 1; i2 < numbers.length; i2++) {
                int sum = numbers[i1] + numbers[i2];
                
                if (sum == target) {
                    result[0] = i1 + 1;
                    result[1] = i2 + 1;
                    
                    return result;
                }
            }
        }
        
        return result;
    }
}
