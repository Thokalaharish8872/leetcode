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

            return dp[i][prev] = pick.size() > notPick.size() ? pick : notPick;
        }
        
        return dp[i][prev] = f(nums, dp, i - 1, prev);
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;
        List<Integer>[][] dp = new ArrayList[n + 1][n + 1];
        
        for(int prev = 0; prev <= n; prev++)
            dp[0][prev] = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            for(int prev = 1; prev <= n; prev++){
                List<Integer> notPick = dp[i - 1][prev];
                List<Integer> best = notPick;

                if(prev == n || nums[prev] % nums[i - 1] == 0){
                    List<Integer> pick = new ArrayList<>(dp[i - 1][i - 1]);
                    pick.add(nums[i - 1]);

                    if(pick.size() > best.size())
                        best = pick;
                }

                dp[i][prev] = best;
            }
        }

        return dp[n][n];
    }
}