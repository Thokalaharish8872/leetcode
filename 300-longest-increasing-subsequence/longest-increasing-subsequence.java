
class Solution {
    private int f(int[] nums1, int[] nums2, int[][] dp, int i, int j){
        if(i == -1 || j == -1)
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];

        if(nums1[i] == nums2[j])
            return dp[i][j] = 1 + f(nums1, nums2, dp, i - 1, j - 1);
        
        return dp[i][j] = Math.max(
                f(nums1, nums2, dp, i - 1, j),
                f(nums1, nums2, dp, i, j - 1)
            );
    }

    public int lengthOfLIS(int[] nums1) {
        
        int[] nums2 = Arrays.stream(nums1)
                        .sorted()
                        .distinct()
                        .toArray();

        int n = nums1.length, m = nums2.length;

        int[][] dp = new int[n + 1][m + 1];
        for(int[] d : dp)
            Arrays.fill(d, -1);

        return f(nums1, nums2, dp, n - 1, m - 1);
    }
}

// maintaining prev greater value 

// class Solution {
//     private int f(int[] prices, int[][] dp, int prev, int i){
//         if(i == -1)
//             return 0;
        
//         if(dp[i][prev] != -1)
//             return dp[i][prev];

//         int notPick = f(prices, dp, prev, i - 1);

//         int pick = 0;
//         if(prev == prices.length || prices[i] < prices[prev])
//             pick = 1 + f(prices, dp, i, i -1);
        
//         return dp[i][prev] = Math.max(pick, notPick);
//     }

//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;

//         int[][] dp = new int[n + 1][n + 1];

//         for(int i = 1; i <= n; i++){
//             for(int j = 1; j <= n; j++){
//                 int notPick = dp[i - 1][j];

//                 int pick = 0;
//                 if(nums[i - 1] < nums[j - 1])
//                     pick = 1 + dp[i - 1][j];
                
//                 dp[i][j] = Math.max(pick, notPick);
//             }
//         }

//         return dp[n][n];
//     }
// }