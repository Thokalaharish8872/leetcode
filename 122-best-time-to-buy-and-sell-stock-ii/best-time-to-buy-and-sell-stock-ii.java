
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 1][2];
        dp[0][1] = -(int)1e9;

        for(int i = 1; i <= n; i++){
            dp[i][1] = Math.max(
                -prices[i - 1] + dp[i - 1][0],
                dp[i - 1][1]
            );

            dp[i][0] = Math.max(
                prices[i - 1] + dp[i - 1][1],
                dp[i - 1][0]
            );
        }

        return dp[n][0];
    }
}

// recursion + memoiation

// class Solution {
//     private int f(int[] prices, int[][] dp, int i, int buy){
//         if(i == prices.length)
//             return 0;

//         if(dp[i][buy] != -1)
//             return dp[i][buy];
        
//         if(buy == 1){
//             return dp[i][buy] = Math.max(
//                 f(prices, dp, i + 1, 0) - prices[i],
//                 f(prices, dp, i + 1, 1)
//             );
//         }

//         return dp[i][buy] = Math.max(
//             f(prices, dp, i + 1, 1) + prices[i],
//             f(prices, dp, i + 1, 0)
//         );
//     }

//     public int maxProfit(int[] prices) {
//         int n = prices.length;

//         int[][] dp = new int[n][2];

//         for(int[] d : dp)
//             Arrays.fill(d, -1);
        
//         return f(prices, dp, 0, 1);
//     }
// }