class Solution {
    public int longestPalindromeSubseq(String s1) {

        String s2 = new StringBuilder(s1).reverse().toString();
        int n = s1.length();
        
        int[] prev;
        int[] curr = new int[n + 1];

        for(int i = 1; i <= n; i++){

            prev = curr;
            curr = new int[n + 1];

            for(int j = 1; j <= n; j++){

                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    curr[j] = 1 + prev[j - 1];
                
                else
                    curr[j] = Math.max(curr[j - 1], prev[j]);
            }
        }

        return curr[n];
    }
}

    // Tabulation

    // public int longestPalindromeSubseq(String s1) {
    //     String s2 = new StringBuilder(s1).reverse().toString();

    //     int n = s1.length();
    //     int[][] dp = new int[n + 1][n + 1];

    //     for(int i = 1; i <= n; i++){
    //         for(int j = 1; j <= n; j++){

    //             if(s1.charAt(i - 1) == s2.charAt(j - 1))
    //                 dp[i][j] = 1 + dp[i - 1][j - 1];
                
    //             else
    //                 dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
    //         }
    //     }
        
    //     return dp[n][n];
    // }
// }