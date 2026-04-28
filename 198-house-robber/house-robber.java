class Solution {
    private int rec(int[] nums, int[] dp, int i){
        if(i == 0) return nums[0];
        else if(i == -1) return 0;

        if(dp[i] != -1) return dp[i];

        int pick = nums[i] + rec(nums, dp, i - 2);
        int notPick = rec(nums, dp, i - 1);

        return dp[i] = Math.max(pick, notPick);
    }
    public int rob(int[] nums) {
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return rec(nums, dp, nums.length - 1);
    }
}