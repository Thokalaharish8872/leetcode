class Solution {
    private int dijkstra(List<List<Integer>> grid, int[][] nearest, int[] dir, boolean[][] vis, PriorityQueue<int[]> pq, int n){

        while(!pq.isEmpty()){
            int[] curr = pq.remove();
            int curri = curr[0];
            int currj = curr[1];
            int safe = curr[2];

            if(vis[curri][currj])
                continue;

            vis[curri][currj] = true;

            if(curri == n - 1 && currj == n - 1){
                return safe;
            }

            for(int k = 1; k < 5; k++){
                int nexti = curri + dir[k];
                int nextj = currj + dir[k - 1];

                if(nexti >= 0 && nexti < n && nextj >= 0 && nextj < n){
                    if(!vis[nexti][nextj]){
                        pq.add(new int[]{nexti, nextj, Math.min(safe, nearest[nexti][nextj])});
                    }
                }
            }
        }

        return 0;
    }

    private void bfs(List<List<Integer>> grid, int[][] nearest, int[] dir, Queue<int[]> q, int n){

        while(!q.isEmpty()){
            int sz = q.size();

            while(sz-- != 0){

                int[] curr = q.remove();

                int curri = curr[0];
                int currj = curr[1];

                for(int k = 1; k < 5; k++){
                    int nexti = curri + dir[k];
                    int nextj = currj + dir[k - 1];

                    if(nexti >= 0 && nexti < n && nextj >= 0 && nextj < n){
                        if(nearest[nexti][nextj] == -1){

                            nearest[nexti][nextj] = nearest[curri][currj] + 1;
                            q.add(new int[]{nexti, nextj, -1});

                        }
                    }
                }
            }
        }
    }

    private int findMaxSafenessFactor(List<List<Integer>> grid, int[] dir, int[][] nearest, int n){
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[2], a[2])
        );

        pq.add(new int[]{0, 0, nearest[0][0]});

        boolean[][] vis = new boolean[n][n];

        return dijkstra(grid, nearest, dir, vis, pq, n);
    }

    private int[][] findNearestCells(List<List<Integer>> grid, int[] dir, int n){

        int[][] nearest = new int[n][n];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){

                if(grid.get(i).get(j) == 1){
                    q.add(new int[]{i, j});
                    nearest[i][j] = 0;
                }
                else
                    nearest[i][j] = -1;
            }
        }

        bfs(grid, nearest, dir, q, n);
        
        return nearest;
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();
        int[] dir = new int[]{0, 1, 0, -1, 0};

        int[][] nearest = findNearestCells(grid, dir, n);
        int maxSafenessFactor = findMaxSafenessFactor(grid, dir, nearest, n);

        return maxSafenessFactor;
    }
}