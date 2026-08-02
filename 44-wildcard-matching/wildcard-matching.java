class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        
        boolean[] prev = new boolean[n + 1];
        boolean[] curr = new boolean[n + 1];

        prev[0] = true;

        for(int j = 1; j <= n && p.charAt(j - 1) == '*'; j++)
            prev[j] = true;
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){

                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                    curr[j] = prev[j - 1];

                else if(p.charAt(j - 1) == '*')
                    curr[j] = prev[j] || curr[j - 1];
                else
                    curr[j] = false;
            }

            prev[0] = false;

            boolean[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }
}

// class Solution {
//     private boolean f(String s, String p, int[][] dp, int i, int j){
//         if(i == -1 && j == -1)
//             return true;
//         if(j == -1)
//             return false;
        
//         if(i == -1){
//             while(j >= 0 && p.charAt(j) == '*')
//                 j--;
//             return j == -1;
//         }

//         if(dp[i][j] != -1)
//             return dp[i][j] == 1;
            
//         if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
//             boolean res = f(s, p, dp, i - 1, j - 1);
//             dp[i][j] =  res ? 1 : 0;

//             return res;
//         }

//         if(p.charAt(j) == '*'){
//             boolean res = f(s, p, dp, i, j - 1) || f(s, p, dp, i - 1, j);
//             dp[i][j] = res ? 1 : 0;
//             return res;
//         }
        
//         dp[i][j] = 0;
//         return false;
//     }
//     public boolean isMatch(String s, String p) {
//         int m = s.length(), n = p.length();

//         int[][] dp = new int[m][n];
//         for(int[] d : dp)
//             Arrays.fill(d, -1);

//         return f(s, p, dp, m - 1, n - 1);
//     }
// }