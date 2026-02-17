class Solution {
    private int bfs(int[][] grid, boolean[][] isVisited, int[] dir, int m, int n){

        int freshOranges = 0, maxTime = 0;
        Queue<Pair<Pair<Integer, Integer>, Integer>> q = new LinkedList<>();

        // get initial rotten oranges
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){

                if(grid[i][j] == 2) q.add(new Pair<>(new Pair<>(i, j), 0));
                else if(grid[i][j] == 1) freshOranges++;
            }
        }
    
        while(!q.isEmpty()){

            Pair<Pair<Integer, Integer>, Integer> pair = q.remove();

            Pair<Integer, Integer> p = pair.getKey();
            int prevR = p.getKey();
            int prevC = p.getValue();

            int time = pair.getValue();
            maxTime = Math.max(maxTime, time);

            for(int i = 1; i < 5; i++){

                int nextR = prevR + dir[i];
                int nextC = prevC + dir[i - 1];

                if(nextR >= 0 && nextC >= 0 && nextR < m && nextC < n){
                    if(!isVisited[nextR][nextC] && grid[nextR][nextC] == 1){

                        isVisited[nextR][nextC] = true;
                        grid[nextR][nextC] = 2;
                        freshOranges--;

                        q.add(new Pair<>(new Pair<>(nextR, nextC), time + 1));
                    }
                }
            }
        }

        return freshOranges == 0 ? maxTime : -1;
    }

    public int orangesRotting(int[][] grid) {

        int m = grid.length, n = grid[0].length;

        int[] dir = new int[]{0, 1, 0, -1, 0};
        boolean[][] isVisited = new boolean[m][n];

        return bfs(grid, isVisited, dir, m, n);
    }
}