class Solution {
    public boolean validPath(int n, int[][] edges, int source, int dest) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v); // u --> v
            graph.get(v).add(u); // v --> u
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(source);

        boolean[] vis = new boolean[n];
        vis[source] = true;

        while(!q.isEmpty()){
            int u = q.poll();

            if(u == dest)
                return true;
            
            for(int v : graph.get(u)){
                if(!vis[v]){
                    vis[v] = true;
                    q.add(v);
                }
            }
        }

        return false;
    }
}