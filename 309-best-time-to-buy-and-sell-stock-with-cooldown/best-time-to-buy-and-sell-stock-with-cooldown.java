// recursion + memoiation

class Solution {
    private int f(int[] prices, int[][] dp, int i, int buy){
        if(i > prices.length)
            return 0;

        if(dp[i][buy] != -1)
            return dp[i][buy];

        if(buy == 1){
            return dp[i][buy] = Math.max(
                -prices[i - 1] + f(prices, dp, i + 1, 0),
                f(prices, dp, i + 1, 1)
            );
        }

        return dp[i][buy] = Math.max(
            prices[i - 1] + f(prices, dp, i + 2, 1),
            f(prices, dp, i + 1, 0)
        );
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 1][2];
        for(int[] d : dp)
            Arrays.fill(d, -1);

        return f(prices, dp, 1, 1);
    }
}