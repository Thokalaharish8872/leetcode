class Solution {
    private boolean f(String s, String p, int[][] dp, int i, int j){
        if(i == -1 && j == -1)
            return true;
        if(j == -1)
            return false;
        
        if(i == -1){
            while(j >= 0 && p.charAt(j) == '*')
                j--;
            return j == -1;
        }

        if(dp[i][j] != -1)
            return dp[i][j] == 1;
            
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            boolean res = f(s, p, dp, i - 1, j - 1);
            dp[i][j] =  res ? 1 : 0;

            return res;
        }

        if(p.charAt(j) == '*'){
            boolean res = f(s, p, dp, i, j - 1) || f(s, p, dp, i - 1, j);
            dp[i][j] = res ? 1 : 0;
            return res;
        }
        
        dp[i][j] = 0;
        return false;
    }
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();

        int[][] dp = new int[m][n];
        for(int[] d : dp)
            Arrays.fill(d, -1);

        return f(s, p, dp, m - 1, n - 1);
    }
}