/*
On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
*/

class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) return Math.min(cost[0], cost[1]);
        
        int[] memo = new int[cost.length + 1];
        memo[0] = cost[0];
        memo[1] = cost[0];
        memo[2] = cost[0];
        
        for (int i = 3; i < memo.length; i++) {
            memo[i] = Math.min(cost[i-1] + memo[i-1], cost[i-2] + memo[i-2]);
        }
        
        int min = memo[memo.length - 1];
        
        memo[0] = 0;
        memo[1] = cost[1];
        memo[2] = cost[1];
        memo[3] = cost[1];
        
        for (int i = 4; i < memo.length; i++) {
            memo[i] = Math.min(cost[i-1] + memo[i-1], cost[i-2] + memo[i-2]);
        }
        
        return Math.min(min, memo[memo.length - 1]);
    }
}
