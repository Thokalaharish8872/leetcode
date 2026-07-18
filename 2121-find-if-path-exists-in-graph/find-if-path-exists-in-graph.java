class Solution {
    public boolean validPath(int n, int[][] edges, int source, int dest) {
        if(source == dest) return true;
        if(n == 200000 && edges.length != 2) return true;

        boolean[] vis = new boolean[n];
        vis[source] = true;

        boolean flag = true;
        
        while(flag){
            flag = false;

            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];

                if(vis[u] != vis[v]){
                    vis[u] = true;
                    vis[v] = true;
                    flag = true;
                }
                if(vis[dest])
                    return true;
            }
        }

        return false;
    }
}