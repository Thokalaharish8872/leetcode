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

        for(int num : nums)
            sum += num;
        
        if(sum % 2 == 1)
            return false;

        int target = sum / 2;

        boolean[][] dp = new boolean[n][target + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], false);
            dp[i][0] = true;
        }

        for(int i = 1; i < n; i++){
            for(int j = target; j > 0; j--){
                boolean notPick = dp[i - 1][j];
                boolean pick = j >= nums[i] ? dp[i - 1][j - nums[i]] : false;

                dp[i][j] = pick || notPick;
            }
        }

        return dp[n - 1][target];
    }
}