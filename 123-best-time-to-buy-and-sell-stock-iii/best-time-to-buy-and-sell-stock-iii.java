class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][3][2];

        for(int i = n - 1; i >= 0; i--){
            for(int transactions = 2; transactions > 0; transactions--){
                for(int buy = 0; buy < 2; buy++){
                    if(buy == 1)
                        dp[i][transactions][buy] = Math.max(-prices[i] + dp[i + 1][transactions][0],  dp[i + 1][transactions][1]);
                    else
                        dp[i][transactions][buy] = Math.max(prices[i] + dp[i + 1][transactions - 1][1],  dp[i + 1][transactions][0]);
                }
            }
        }

        return dp[0][2][1];
    }
}


// recursion + memoiation

// class Solution {
//     private int f(int[] prices, int[][][] dp, int i, int transactions, int buy){
//         if(transactions == -1 || i == prices.length)
//             return 0;

//         if(dp[i][transactions][buy] != -1)
//             return dp[i][transactions][buy];

//         if(buy == 1)
//             return dp[i][transactions][buy] = Math.max(
//                     -prices[i] + f(prices, dp, i + 1, transactions, 0), 
//                     f(prices, dp, i + 1, transactions, 1)
//                 );

//         return dp[i][transactions][buy] = Math.max(
//                 prices[i] + f(prices, dp, i + 1, transactions - 1, 1), 
//                 f(prices, dp, i + 1, transactions, 0)
//             );
//     }

//     public int maxProfit(int[] prices) {
//         int n = prices.length;

//         int[][][] dp = new int[n + 1][2][2];
//         for(int[][] d : dp)
//             for(int[] p : d)
//                 Arrays.fill(p, -1);

//         return f(prices, dp, 0, 1, 1);
//     }
// }