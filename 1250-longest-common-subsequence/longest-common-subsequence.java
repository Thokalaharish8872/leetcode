class Solution {
    private int f(String text1, String text2, int[][] dp, int i, int j){
        if(i == -1 || j == -1)
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];

        if(text1.charAt(i) == text2.charAt(j))
            return dp[i][j] = 1 + f(text1, text2, dp, i - 1, j - 1);
        else
            return dp[i][j] = Math.max(f(text1, text2, dp, i - 1, j), f(text1, text2, dp, i, j - 1));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();

        int[][] dp = new int[m][n];
        for(int[] d : dp)
            Arrays.fill(d, -1);

        return f(text1, text2, dp, m - 1, n - 1);
    }

    // tabulation space optimized

    // public int longestCommonSubsequence(String text1, String text2) {
    //     int m = text1.length(), n = text2.length();

    //     int[] prev;
    //     int[] curr = new int[n + 1];

    //     for(int i = 1; i <= m; i++){
            
    //         prev = curr;
    //         curr = new int[n + 1];

    //         for(int j = 1; j <= n; j++){

    //             if(text1.charAt(i - 1) == text2.charAt(j - 1))
    //                 curr[j] = 1 + prev[j - 1];
    //             else
    //                 curr[j] = Math.max(curr[j - 1], prev[j]);
    //         }

    //     }

    //     return curr[n];
    // }

    // Tabulation 
            
    // public int longestCommonSubsequence(String text1, String text2) {
    //     int m = text1.length(), n = text2.length();

    //     int[][] dp = new int[m + 1][n + 1];

    //     for(int i = 1; i <= m; i++){
    //         for(int j = 1; j <= n; j++){
                
    //             if(text1.charAt(i - 1) == text2.charAt(j - 1))
    //                 dp[i][j] = 1 + dp[i - 1][j - 1];
    //             else
    //                 dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
    //         }
    //     }

    //     return dp[m][n];
    // }
}