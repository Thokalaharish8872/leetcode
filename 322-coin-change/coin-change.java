class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for(int[] d : dp)
            Arrays.fill(d, (int)1e9);

        for(int i = 1; i <= n; i++)
            dp[i][0] = 0;

        for(int i = 1; i <= n; i++){
            for(int target = 1; target <= amount; target++){

                int notPick = dp[i - 1][target];
                int pick = target < coins[i - 1] ? (int)1e9 : dp[i][target - coins[i - 1]] + 1;

                dp[i][target] = Math.min(pick, notPick);
            }
        }

        return dp[n][amount] == (int)1e9 ? -1 : dp[n][amount];
    }
}