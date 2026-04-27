class Solution {
    
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dir = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };

        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{m - 1, n - 1, -1, -1});
        vis[m - 1][n - 1] = true;

        while(!q.isEmpty()){
            int sz = q.size();

            while(sz-- != 0){
                int[] p = q.remove();
                int ci = p[0], pi = p[2];
                int cj = p[1], pj = p[3];

                if(ci == 0 && cj == 0) return true;

                for(int k = 0; k < 4; k++){
                    int ni = ci + dir[k][0];
                    int nj = cj + dir[k][1];

                    int type = grid[ci][cj];

                    boolean canGo = false;
                    
                    if (type == 1 && (k == 0 || k == 2)) canGo = true;
                    if (type == 2 && (k == 1 || k == 3)) canGo = true;
                    if (type == 3 && (k == 2 || k == 1)) canGo = true;
                    if (type == 4 && (k == 0 || k == 1)) canGo = true;
                    if (type == 5 && (k == 2 || k == 3)) canGo = true;
                    if (type == 6 && (k == 0 || k == 3)) canGo = true;
                    
                    if (!canGo) continue;
                    
                    if(ni >= 0 && nj >= 0 && ni < m && nj < n){
                        if(ni == pi && nj == pj) continue;
                        if(vis[ni][nj]) continue;

                        if(k == 0 && (grid[ni][nj] == 1 || 
                            grid[ni][nj] == 3 || grid[ni][nj] == 5)){
                            q.add(new int[]{ni, nj, ci, cj});
                            vis[ni][nj] = true;
                        }
                        else if(k == 1 && (grid[ni][nj] == 2 || 
                            grid[ni][nj] == 5 || grid[ni][nj] == 6)){
                                q.add(new int[]{ni, nj, ci, cj});
                                vis[ni][nj] = true;
                        }
                        else if(k == 2 && (grid[ni][nj] == 1 || 
                            grid[ni][nj] == 4 || grid[ni][nj] == 6)){
                                q.add(new int[]{ni, nj, ci, cj});
                                vis[ni][nj] = true;
                        }
                        else if(k == 3 && (grid[ni][nj] == 2 || 
                            grid[ni][nj] == 3 || grid[ni][nj] == 4)){
                                q.add(new int[]{ni, nj, ci, cj});
                                vis[ni][nj] = true;
                        }
                    }
                }
            }
        }

        return false;
    }
}