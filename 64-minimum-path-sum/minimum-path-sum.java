class Solution {
    private int dfs(int[][] grid, int[][] minPath, int m, int n, int i, int j){
        if(i == 0 && j == 0)
            return grid[i][j];
        
        if(i < 0 || j < 0)
            return Integer.MAX_VALUE;

        if(minPath[i][j] != -1)
            return minPath[i][j];

        return minPath[i][j] = 
                Math.min(dfs(grid, minPath, m, n, i - 1, j),
                        dfs(grid, minPath, m, n, i, j - 1)) + grid[i][j];
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] minPath = new int[m][n];

        for(int[] path : minPath)
            Arrays.fill(path, -1);
        
        return dfs(grid, minPath, m, n, m - 1, n - 1);
    }
}