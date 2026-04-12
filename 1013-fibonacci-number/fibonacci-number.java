class Solution {
    static int[] dp = new int[31];

    static {
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= 30; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    }

    public int fib(int n) {
        return dp[n];
    }
}