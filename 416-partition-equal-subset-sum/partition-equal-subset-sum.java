class Solution {
    private int f(int[] nums, int[][] dp, int target, int i){
        if(target == 0)
            return 1;
        
        if(i < 0 || target < 0)
            return 0;
    
        if(dp[i][target] != -1)
            return dp[i][target];
        
        return dp[i][target] = ((f(nums, dp, target - nums[i], i - 1) == 1) || 
                    (f(nums, dp, target, i - 1) == 1)) ? 1 : 0;
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        int[][] dp = new int[n][2  * 100_00 + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
            sum += nums[i];
        }

        if(sum % 2 == 1)
            return false;

        return f(nums, dp, sum / 2, n - 1) == 1;
    }
}