class Solution {
    private int f(int[] prices, int[][] dp, int i, int buy, int fee){
        if(i == prices.length)
            return 0;

        if(dp[i][buy] != -1)
            return dp[i][buy];

        if(buy == 1)
            return dp[i][buy] = Math.max(-prices[i] + f(prices, dp, i + 1, 0, fee), f(prices, dp, i + 1, 1, fee));
        
        return dp[i][buy] = Math.max(prices[i] + f(prices, dp, i + 1, 1, fee) - fee, f(prices, dp, i + 1, 0, fee));
    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int[][] dp = new int[n + 1][2];
        for(int[] d : dp)
            Arrays.fill(d, -1);
        
        return f(prices, dp, 0, 1, fee);
    }
}