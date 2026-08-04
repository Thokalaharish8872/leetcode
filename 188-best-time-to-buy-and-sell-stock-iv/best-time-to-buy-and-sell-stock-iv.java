class Solution{
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[] next = new int[2 * k + 1];
        int[] curr = new int[2 * k + 1];

        for(int i = n - 1; i >= 0; i--){
            for(int j = 1; j <= 2 * k; j++){
                if((j & 1) == 0)
                    curr[j] = Math.max(-prices[i] + next[j - 1], next[j]);
                else
                    curr[j] = Math.max(prices[i] + next[j - 1], next[j]);
            }

            int[] temp = next;
            next = curr;
            curr = temp;
        }
            
        return next[2 * k];
    }
}

// recursion with memoiation

// class Solution {
//     private int f(int[] prices, int[][] dp, int i, int k){
//         if(i == prices.length || k == 0)
//             return 0;

//         if(dp[i][k] != -1)
//             return dp[i][k];

//         if((k & 1) == 0){
//             return dp[i][k] = Math.max(
//                 -prices[i] + f(prices, dp, i + 1, k - 1),
//                 f(prices, dp, i + 1, k)
//             );
//         }

//         return dp[i][k] = Math.max(
//             prices[i] + f(prices, dp, i + 1, k - 1),
//             f(prices, dp, i + 1, k)
//         );
//     }

//     public int maxProfit(int k, int[] prices) {
//         int n = prices.length;

//         int[][] dp = new int[n + 1][2*k + 1];
//         for(int[] d : dp)
//             Arrays.fill(d, -1);

//         return f(prices, dp, 0, 2 * k);
//     }
// }