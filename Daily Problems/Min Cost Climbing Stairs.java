class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 0) {
            return 0;
        }

        // Create an array to store the minimum cost to reach each step.
        int[] dp = new int[n];

        // Base case: the minimum cost to reach the first and second steps.
        dp[0] = cost[0];
        dp[1] = cost[1];

        // Iterate through the remaining steps and calculate the minimum cost.
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        // The minimum cost to reach the top is the minimum of the last two steps.
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
