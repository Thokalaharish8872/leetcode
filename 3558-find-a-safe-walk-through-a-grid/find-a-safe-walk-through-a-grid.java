class Solution {
    private boolean dijktra(List<List<Integer>> grid, int health){
        int m = grid.size(), n = grid.get(0).size();

        int[][] cellHealth = new int[m][n];
        int[] dir = new int[]{0, 1, 0, -1, 0};
        
        for(int[] h : cellHealth){
            Arrays.fill(h, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> Integer.compare(a[2], b[2]));
        pq.add(new int[]{m - 1, n - 1, grid.get(m - 1).get(n - 1)});
        cellHealth[m - 1][n - 1] = grid.get(m - 1).get(n - 1);

        while(!pq.isEmpty()){

            int[] curr = pq.remove();
            int ci = curr[0];
            int cj = curr[1];
            int h = curr[2];

            if(h > cellHealth[ci][cj])
                continue;
            
            for(int k = 1; k < 5; k++){
                int ni = ci + dir[k];
                int nj = cj + dir[k - 1];

                if(ni >= 0 && ni < m && nj >=0 && nj < n){
                    int newCost = h + grid.get(ni).get(nj);

                    if(newCost < cellHealth[ni][nj]){
                        cellHealth[ni][nj] = newCost;
                        pq.add(new int[]{ni, nj, newCost});
                    }
                }
            }
        }
        
        return health > cellHealth[0][0];
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        return dijktra(grid, health);
    }
}