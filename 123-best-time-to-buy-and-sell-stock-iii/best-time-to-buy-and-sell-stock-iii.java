class Solution {
    private int f(int[] prices, int[][][] dp, int i, int transactions, int buy){
        if(transactions == -1 || i == prices.length)
            return 0;

        if(dp[i][transactions][buy] != -1)
            return dp[i][transactions][buy];

        if(buy == 1)
            return dp[i][transactions][buy] = Math.max(
                    -prices[i] + f(prices, dp, i + 1, transactions, 0), 
                    f(prices, dp, i + 1, transactions, 1)
                );

        return dp[i][transactions][buy] = Math.max(
                prices[i] + f(prices, dp, i + 1, transactions - 1, 1), 
                f(prices, dp, i + 1, transactions, 0)
            );
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n + 1][2][2];
        for(int[][] d : dp)
            for(int[] p : d)
                Arrays.fill(p, -1);

        return f(prices, dp, 0, 1, 1);
    }
}