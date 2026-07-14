class Solution {

    private int gcd(int a, int b){
        while(b > 0){
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    private int f(int[] nums, int[][][] dp, int g1, int g2, int i){
        if(i == -1)
            return g1 != 0 && g1 == g2 ? 1 : 0;

        if(dp[i][g1][g2] != -1)
            return dp[i][g1][g2];

        int ignore = f(nums, dp, g1, g2, i - 1);
        int seq1 = f(nums, dp, gcd(g1, nums[i]), g2, i - 1);
        int seq2 = f(nums, dp, g1, gcd(g2, nums[i]), i - 1);

        return dp[i][g1][g2] = (int)((1L * ignore + seq1 + seq2) % 1_000_000_007);
    }

    public int subsequencePairCount(int[] nums) {

        int n = nums.length;
        int[][][] dp = new int[n][201][201];

        for(int[][] d : dp)
            for(int[] p : d)
                Arrays.fill(p, -1);

        return f(nums, dp, 0, 0, n - 1);
    }
}