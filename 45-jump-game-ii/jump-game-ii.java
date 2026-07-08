class Solution {
    private int f(int[] nums, int[] dp, int n, int i){
        if(i == n - 1)
            return 0;

        if(i >= n)
            return (int)1e9;

        if(dp[i] != -1)
            return dp[i];
        
        int min = (int)1e9;
        
        for(int j = nums[i]; j > 0; j--)
            min = Math.min(min, 1 + f(nums, dp, n, i + j));
        
        return dp[i] = min;
    }
    public int jump(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return f(nums, dp, n, 0);
    }
}