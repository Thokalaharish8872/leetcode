class Solution {

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++)
            dp[i][0] = 1;
            
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                int notPick = dp[i - 1][j];

                int pick = 0;
                if(s.charAt(i - 1) == t.charAt(j - 1))
                    pick = dp[i - 1][j - 1];

                dp[i][j] = pick + notPick;
            }
        }

        return dp[m][n];
    }
}

    // Recursion with memoiation

    // private int f(String s, String t, int[][] dp, String str, int i, int j){
    //     if(j == -1)
    //         return str.equals(t) ? 1 : 0;

    //     if(i == -1)
    //         return 0;
            
    //     if(dp[i][j] != -1)
    //         return dp[i][j];

    //     int notPick = f(s, t, dp, str, i - 1, j);

    //     int pick = 0;
    //     if(s.charAt(i) == t.charAt(j))
    //         pick = f(s, t, dp, s.charAt(i) + str, i - 1, j - 1);
        
    //     return dp[i][j] = pick + notPick;
    // }

    // public int numDistinct(String s, String t) {
    //     int m = s.length();
    //     int n = t.length();

    //     int[][] dp = new int[m][n];
    //     for(int[] d : dp)
    //         Arrays.fill(d, -1);

    //     return f(s, t, dp, "", m - 1, n - 1);
    // }
// }