class Solution {
    private long dfs(int[][] grid, int[] dir, int i, int j, int m, int n){
                
        long sum = grid[i][j];
        grid[i][j] = 0;

        for(int k = 1; k < 5; k++){
            int ni = i + dir[k];
            int nj = j + dir[k - 1];

            if(ni < 0 || nj < 0 || ni >= m || nj >= n || grid[ni][nj] == 0) 
                continue;

            sum += dfs(grid, dir, ni, nj, m, n);
        }

        return sum;
    }
    public int countIslands(int[][] grid, int k) {
        
        int m = grid.length, n = grid[0].length;
        int[] dir = new int[]{0, 1, 0, -1, 0};
        int validIslands = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(grid[i][j] != 0){
                    long totalVal = dfs(grid, dir, i, j, m, n);
                    if(totalVal % k == 0)
                        validIslands++;
                }
                
            }
        }

        return validIslands;
    }
}