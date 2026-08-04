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

        int[] next = new int[2];
        int[] curr = new int[2];

        for(int i = n - 1; i >= 0; i--){
            curr[0] = Math.max(prices[i] + next[1] - fee, next[0]);
            curr[1] = Math.max(-prices[i] + next[0], next[1]);

            int[] temp = next;
            next = curr;
            curr = temp;
        }
        
        return next[1];
    }
}