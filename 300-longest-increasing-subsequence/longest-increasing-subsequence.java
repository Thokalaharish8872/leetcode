
// maintaining prev greater value 

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        int max = 0;

        for(int i = 0; i < n; i++){
            for(int prev = 0; prev < i; prev++){
                if(nums[prev] < nums[i]){
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);

                    max = Math.max(max, dp[i]);
                }
            }
        }

        // intially the dp should filled with 1 to minimize runtime we kept it as 0 and then later we added one to make it balance
        return max + 1;
    }
}