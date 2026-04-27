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

                        int nextType = grid[ni][nj];

                        boolean canComeBack = false;

                        int rev = (k + 2) % 4;

                        if (nextType == 1 && (rev == 0 || rev == 2)) canComeBack = true;
                        if (nextType == 2 && (rev == 1 || rev == 3)) canComeBack = true;
                        if (nextType == 3 && (rev == 2 || rev == 1)) canComeBack = true;
                        if (nextType == 4 && (rev == 0 || rev == 1)) canComeBack = true;
                        if (nextType == 5 && (rev == 2 || rev == 3)) canComeBack = true;
                        if (nextType == 6 && (rev == 0 || rev == 3)) canComeBack = true;

                        if (!canComeBack) continue;

                        q.add(new int[]{ni, nj, ci, cj});
                        vis[ni][nj] = true;
                    }
                }
            }
        }

        return false;
    }
}