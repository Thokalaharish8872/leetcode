class Solution {
    private int dfs(int m, int n, int[][] dp, int i, int j){
        if(i == 0 && j == 0)
            return 1;

        if(i < 0 || j < 0)
            return 0;

        else if(dp[i][j] != -1)
            return dp[i][j];

        return dp[i][j] = 
            dfs(m, n, dp, i - 1, j) + 
            dfs(m, n, dp, i, j - 1);
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int[] d : dp)
            Arrays.fill(d, -1);

        return dfs(m, n, dp, m - 1, n - 1);

    }
}