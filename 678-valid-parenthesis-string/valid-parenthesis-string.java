class Solution {
    private int f(String s, int[][][] dp, int i, int open, int close){
        if(i == s.length())
            return open == close ? 1 : 0;

        if(close > open)
            return 0;

        if(dp[i][open][close] != -1)
            return dp[i][open][close];

        char ch = s.charAt(i);

        if(ch == '(')
            return dp[i][open][close] = f(s, dp, i + 1, open + 1, close);
        if(ch == ')')
            return dp[i][open][close] = f(s, dp, i + 1, open, close + 1);

        return dp[i][open][close] = (f(s, dp, i + 1, open, close) == 1 || 
                f(s, dp, i + 1, open + 1, close) == 1 || 
                f(s, dp, i + 1, open, close + 1) == 1) ? 1 : 0;
    }
    public boolean checkValidString(String s) {
        int n = s.length();

        int[][][] dp = new int[n][n][n];
        for(int[][] d : dp)
            for(int[] p : d)
                Arrays.fill(p, -1);

        return f(s, dp, 0, 0, 0) == 1;
    }
}