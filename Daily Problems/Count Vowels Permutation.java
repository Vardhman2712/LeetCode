class Solution {
    public int countVowelPermutation(int n) {
        int MOD = 1_000_000_007;

        // Create a 2D array to store the count of valid strings ending with each vowel.
        long[][] dp = new long[n + 1][5];

        // Initialize the base cases for strings of length 1.
        for (int i = 0; i < 5; i++) {
            dp[1][i] = 1;
        }

        // Build the DP table for strings of length 2 to n.
        for (int len = 2; len <= n; len++) {
            dp[len][0] = (dp[len - 1][1] + dp[len - 1][2] + dp[len - 1][4]) % MOD;
            dp[len][1] = (dp[len - 1][0] + dp[len - 1][2]) % MOD;
            dp[len][2] = (dp[len - 1][1] + dp[len - 1][3]) % MOD;
            dp[len][3] = dp[len - 1][2];
            dp[len][4] = (dp[len - 1][2] + dp[len - 1][3]) % MOD;
        }

        // Calculate the total count of valid strings of length n.
        long totalCount = 0;
        for (int i = 0; i < 5; i++) {
            totalCount = (totalCount + dp[n][i]) % MOD;
        }

        return (int) totalCount; // Cast the result to int before returning.
    }
}
