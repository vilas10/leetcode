/*
Given a list of daily temperatures, produce a list that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
*/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Arrays.fill(result, 0);
        
        for (int i = temperatures.length - 2; i >= 0; i--) {
            result[i] = 1;
            
            if (temperatures[i] >= temperatures[i+1]) {
                int k = i + 1;
                while(result[k] > 0 && temperatures[i] >= temperatures[k]) {
                    result[i] += 1;  
                    k++;
                }
                
                if (result[k] == 0 && temperatures[i] >= temperatures[k]) result[i] = 0;
            }
        }
        
        return result;
        
    }
}
