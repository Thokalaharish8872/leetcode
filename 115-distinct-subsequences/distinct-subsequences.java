
// recursion + memoiation

// class Solution {
//     private int f(String s, String t, int[][] dp, int i, int j){
//         if(j == t.length())
//             return 1;

//         if(i == s.length())
//             return 0;

//         if(dp[i][j] != -1)
//             return dp[i][j];

//         int notPick = f(s, t, dp, i + 1, j);
//         int pick = 0;

//         if(s.charAt(i) == t.charAt(j))
//             pick = f(s, t, dp, i + 1, j + 1);

//         return dp[i][j] = pick + notPick;
//     }

//     public int numDistinct(String s, String t) {

//         int[][] dp = new int[s.length()][t.length()];
//         for(int[] d : dp)
//             Arrays.fill(d, -1);

//         return f(s, t, dp, 0, 0);
//     }
// }

class Solution {
    private int f(String s, String t, int[][] dp, int i, int j){
        if(j == t.length())
            return 1;

        if(i == s.length())
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        int notPick = f(s, t, dp, i + 1, j);
        int pick = 0;

        if(s.charAt(i) == t.charAt(j))
            pick = f(s, t, dp, i + 1, j + 1);

        return dp[i][j] = pick + notPick;
    }

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++)
            dp[i][n] = 1;

        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                int notPick = dp[i + 1][j];
                int pick = 0;

                if(s.charAt(i) == t.charAt(j))
                    pick = dp[i + 1][j + 1];

                dp[i][j] = pick + notPick;
            }
        }

        return dp[0][0];
    }
}