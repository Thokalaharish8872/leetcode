class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int[][] dis = new int[n][n];

        //initialize the matrix step1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j){
                    dis[i][j] = (int)1e9;
                }
            }
        }

        //initialize the matrix step2;
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            dis[u][v] = wt;
            dis[v][u] = wt;
        }

        //find all shortest paths(floyd-warshall Algorithm)
        for(int k = 0; k < n; k++){

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){

                    if(dis[i][k] != (int)1e9 && dis[k][j] != (int)1e9){
                        dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                    }
                }
            }
        }

        int minPaths = n + 1, city = -1;

        // find city with smallest path
        for(int i = 0; i < n; i++){
            int paths = 0;
            for(int j = 0; j < n; j++){
                if(i != j && dis[i][j] <= distanceThreshold) paths++;
            }

            if(paths <= minPaths){
                minPaths = paths;
                city = i;
            }
        }

        return city;
    }
}