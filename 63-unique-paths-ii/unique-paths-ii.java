class Solution {
    private int dfs(int[][] obstacleGrid, int[][] dp, int m, int n, int i, int j){
        if(i == 0 && j == 0 && obstacleGrid[i][j] != 1)
            return 1;
        
        if(i < 0 || j < 0 || obstacleGrid[i][j] == 1)
            return 0;

        if(dp[i][j] != - 1)
            return dp[i][j];

        return dp[i][j] = 
            dfs(obstacleGrid, dp, m, n, i - 1, j) +
            dfs(obstacleGrid, dp, m, n, i, j - 1);


    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for(int[] d : dp)
            Arrays.fill(d, -1);

        return dfs(obstacleGrid, dp, m, n, m - 1, n - 1);
    }
}