class Solution {
    private List<Integer> f(int[] nums, List<Integer>[][] dp, int i, int prev){
        if(i == -1)
            return new ArrayList<>();
        
        if(dp[i][prev] != null)
            return dp[i][prev];
        
        if(prev == nums.length || nums[prev] % nums[i] == 0){
            List<Integer> pick = new ArrayList<>(f(nums, dp, i - 1, i));
            List<Integer> notPick = f(nums, dp, i - 1, prev);

            pick.add(nums[i]);

            System.out.println(pick + "\t" + notPick);

            return dp[i][prev] = pick.size() > notPick.size() ? pick : notPick;
        }
        
        return dp[i][prev] = f(nums, dp, i - 1, prev);
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;
        List<Integer>[][] dp = new ArrayList[n][n + 1];

        return f(nums, dp, n - 1, n);
    }
}