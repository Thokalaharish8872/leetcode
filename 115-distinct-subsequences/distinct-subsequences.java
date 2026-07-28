class Solution {
    // tabulation with space optimization
      public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        prev[0] = 1;
        curr[0] = 1;

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                int notPick = prev[j];

                int pick = 0;
                if(s.charAt(i - 1) == t.charAt(j - 1))
                    pick = prev[j - 1];

                curr[j] = pick + notPick;
            }

            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }
}

    // tabulation 

//     public int numDistinct(String s, String t) {
//         int m = s.length();
//         int n = t.length();

//         int[][] dp = new int[m + 1][n + 1];
//         for(int i = 0; i <= m; i++)
//             dp[i][0] = 1;

//         for(int i = 1; i <= m; i++){
//             for(int j = 1; j <= n; j++){
//                 int notPick = dp[i - 1][j];

//                 int pick = 0;
//                 if(s.charAt(i - 1) == t.charAt(j - 1))
//                     pick = dp[i - 1][j - 1];

//                 dp[i][j] = pick + notPick;
//             }
//         }

//         return dp[m][n];
//     }
// }

    // Recursion with memoiation

    // private int f(String s, String t, int[][] dp, String str, int i, int j){
    //     if(j == -1)
    //         return 1;

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