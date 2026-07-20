class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < m; i++)
            ans.add(new ArrayList<>(Collections.nCopies(n, -1)));
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int ipos = (i + (j + k) / n) %  m;
                int jpos = (j + k) % n; 

                ans.get(ipos).set(jpos, grid[i][j]);
            }
        }

        return ans;
    }
}