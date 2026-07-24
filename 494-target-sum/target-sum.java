class Solution {
    private int f(int[] nums, int target, int[][] dp, int n, int offset){

        if (target > offset || target < -offset)
            return 0;

        if(n == -1)
            return target == 0 ? 1 : 0;

        if(dp[n][target + offset] != -1)
            return dp[n][target + offset];

        int plus = f(nums, target + nums[n], dp, n - 1, offset);
        int minus = f(nums, target - nums[n], dp, n - 1, offset);
        
        return dp[n][target + offset] = plus + minus;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int sum = 0;
        for (int x : nums)
            sum += x;

        int[][] dp = new int[n][2 * sum + 1];
        for(int[] d : dp)
            Arrays.fill(d, -1);

        return f(nums, target, dp, nums.length - 1, sum);
    }
}