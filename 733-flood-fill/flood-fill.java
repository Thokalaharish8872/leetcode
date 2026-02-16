class Solution {

    private void dfs(int[][] image, int sr, int sc, int color, int m, int n, boolean[][] isVisited, 
                        int[] dir, int parentColor){

        image[sr][sc] = color;
        isVisited[sr][sc] = true;

        for(int i = 1; i < dir.length; i++){
            int nextR = sr + dir[i - 1];
            int nextC = sc + dir[i];

            if(nextR >= 0 && nextC >= 0 && nextR < m && nextC < n){
                if(!isVisited[nextR][nextC] && image[nextR][nextC] == parentColor){

                    dfs(image, nextR, nextC, color, m, n, isVisited, dir, parentColor);
                }
            }

        }
    }
    private void bfs(int[][] image, int sr, int sc, int color, int m, int n, boolean[][] isVisited, 
                        int[] dir, int parentColor){

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(sr, sc));
        image[sr][sc] = color;

        while(!q.isEmpty()){

            Pair<Integer, Integer> pair = q.remove();
            int prevR = pair.getKey();
            int prevC = pair.getValue();

            for(int i = 1; i < dir.length; i++){
                int nextR = prevR + dir[i - 1];
                int nextC = prevC + dir[i];

                if(nextR >= 0 && nextC >= 0 && nextR < m && nextC < n){
                    if(!isVisited[nextR][nextC] && image[nextR][nextC] == parentColor){

                        q.add(new Pair<>(nextR, nextC));
                        
                        isVisited[nextR][nextC] = true;
                        image[nextR][nextC] = color;
                    }
                }
            }

        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int m = image.length, n = image[0].length;
        boolean[][] isVisited = new boolean[m][n];
        int[] dir = new int[]{0, -1, 0, 1, 0};

        dfs(image, sr, sc, color, m, n, isVisited, dir, image[sr][sc]);

        return image;
    }
}