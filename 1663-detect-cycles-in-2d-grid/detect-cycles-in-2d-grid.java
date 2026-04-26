class Solution {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] dir = new int[]{0, 1, 0, -1, 0};

        for(int i = 0; i < m; i++){
            for(int j = 0; j  < n; j++){
                if(!visited[i][j]){
                    if(dfs(grid, visited, dir, i, j, -1, -1)) return true;
                }   
            }
        }

        return false;
    }

    private boolean dfs(char[][] grid, boolean[][] visited, int[] dir, int i, int j, int pi, int pj){
        visited[i][j] = true;

        for(int k = 1; k < 5; k++){
            int ni = i + dir[k];
            int nj = j + dir[k - 1];

            if(ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[0].length){
                if(grid[ni][nj] == grid[i][j] && (ni != pi || nj != pj)){

                    if(visited[ni][nj]) return true;
                    if(dfs(grid, visited, dir, ni, nj, i, j)) return true;
                }
            }
        }

        return false;
    }
}