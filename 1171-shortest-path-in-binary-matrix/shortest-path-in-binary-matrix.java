class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        if(n == 1 && grid[0][0] == 0) return 1;
        if(grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;

        int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
        int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
        int[][] dis = new int[n][n];
        for (int[] row : dis) {
            Arrays.fill(row, (int)1e9);
        }

        //djikshtras algo
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0, 0});
        dis[0][0] = 0;

        while(!q.isEmpty()){

            int[] prev = q.remove();
            int d = prev[0];
            int previ = prev[1];
            int prevj = prev[2];

            for(int k = 0; k < 8; k++){
                int curri = previ + dx[k];
                int currj = prevj + dy[k];

                if(curri >= 0 && curri < n && currj >= 0 && currj < n && grid[curri][currj] == 0){
                    if(d + 1 < dis[curri][currj]){
                        dis[curri][currj] = d + 1;
                        q.add(new int[]{d + 1, curri, currj});
                    }

                    if(curri == n - 1 && currj == n - 1) return dis[curri][currj];
                }
            }
        }

        return -1;
    }
}