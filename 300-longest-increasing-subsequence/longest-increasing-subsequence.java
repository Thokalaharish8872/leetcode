class Solution {
    private int f(int[] prices, int[][] dp, int prev, int i){
        if(i == -1)
            return 0;
        
        if(dp[i][prev] != -1)
            return dp[i][prev];

        int notPick = f(prices, dp, prev, i - 1);

        int pick = 0;
        if(prev == prices.length || prices[i] < prices[prev])
            pick = 1 + f(prices, dp, i, i -1);
        
        return dp[i][prev] = Math.max(pick, notPick);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n + 1][n + 1];
        for(int[] d : dp)
            Arrays.fill(d, -1);

        return f(nums, dp, n, n - 1);
    }
}