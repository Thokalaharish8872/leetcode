class Solution {
    private int f(int[] prices, int[][] dp, int i, int k){
        if(i == prices.length || k == 0)
            return 0;

        if(dp[i][k] != -1)
            return dp[i][k];

        if((k & 1) == 0){
            return dp[i][k] = Math.max(
                -prices[i] + f(prices, dp, i + 1, k - 1),
                f(prices, dp, i + 1, k)
            );
        }

        return dp[i][k] = Math.max(
            prices[i] + f(prices, dp, i + 1, k - 1),
            f(prices, dp, i + 1, k)
        );
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 1][2*k + 1];
        for(int[] d : dp)
            Arrays.fill(d, -1);
            
        return f(prices, dp, 0, 2 * k);
    }
}