class Solution {
    private long f(String s, long[] dp, int i, int MOD){
        if(i == s.length())
            return 1;

        if(dp[i] != -1)
            return dp[i];

        char ch = s.charAt(i);
        long res = (2L * f(s, dp, i + 1, MOD)) % MOD;

        int j = i + 1;
        while (j < s.length() && s.charAt(j) != s.charAt(i))
            j++;

        if (j < s.length())
            res = (res - f(s, dp, j + 1, MOD) + MOD) % MOD;

        return dp[i] = res;
    }

    public int distinctSubseqII(String s) {
        int n = s.length();
        int MOD = 100_000_000_7;

        long[] dp = new long[n];
        Arrays.fill(dp, -1);

        return (int)((f(s, dp, 0, MOD) - 1 + MOD) % MOD);    }
}