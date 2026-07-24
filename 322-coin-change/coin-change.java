class Solution {
    private int f(int i, int amount, int[][] dp, int[] coins){
        if(amount == 0)
            return 0;

        if(i == -1)
            return (int)1e9;
        
        if(dp[i][amount] != -1)
            return dp[i][amount];

        int notPick = f(i - 1, amount, dp, coins);
        int pick = amount - coins[i] >= 0 ? f(i, amount - coins[i], dp, coins) + 1: (int) 1e9;

        return dp[i][amount] = Math.min(pick, notPick);
    }
    public int coinChange(int[] coins, int amount) {

        if(amount == 0)
            return 0;
            
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for(int[] d : dp)
            Arrays.fill(d, -1);

        return f(n - 1, amount, dp, coins) == (int)1e9 ? -1 : dp[n - 1][amount];
    }
}