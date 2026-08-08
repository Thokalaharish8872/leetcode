
// maintaining prev greater value 

class Solution {
    private int f(int[] prices, int[][] dp, int prev, int i){
        if(i == -1)
            return 0;
        
        if(dp[i][prev] != -1)
            return dp[i][prev];

        int notPick = f(prices, dp, prev, i - 1);

        int pick = 0;
        if(prev == prices.length || prices[i] < prices[prev])
            pick = 1 + f(prices, dp, i, i - 1);
        
        return dp[i][prev] = Math.max(pick, notPick);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n + 1];

        for (int prev = 1; prev <= n; prev++) {
            if (prev == n || nums[0] < nums[prev])
                dp[0][prev] = 1;
        }

        for(int i = 1; i < n; i++){
            for(int prev = i; prev <= n; prev++){
                int notPick = dp[i - 1][prev];

                int pick = 0;
                if(prev == nums.length || nums[i] < nums[prev])
                    pick = 1 + dp[i - 1][i];

                dp[i][prev] = Math.max(pick, notPick);
            }
        }

        return dp[n - 1][n];
    }
}