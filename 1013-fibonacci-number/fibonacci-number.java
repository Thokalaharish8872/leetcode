class Solution {
    int[] dp;

    private void preCompute(){
        dp = new int[31];
        dp[0] = 0;
        dp[1] = 1;
        
        solve(30);
    }

    private int solve(int n){
        if(n <= 1) return n;
        else if(dp[n] != 0) return dp[n];

        dp[n] = solve(n - 1) + solve(n - 2);
        return dp[n];
    }

    public int fib(int n) {
        if(dp == null) preCompute();

        return dp[n];
    }
}