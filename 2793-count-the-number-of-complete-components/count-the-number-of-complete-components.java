class Solution {

    private int[] dfs(List<List<Integer>> graph, boolean[] vis, int i, int[] vertex){
        vis[i] = true;

        vertex[0]++;
        vertex[1] += graph.get(i).size();

        for(int node : graph.get(i)){
            if(!vis[node])
                dfs(graph, vis, node, vertex);
        }

        return vertex;
    }

    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        int completeComponents = 0;

        for(int i = 0; i < n; i++){
            if(!vis[i]){
                int[] component = dfs(graph, vis, i, new int[]{0, 0});
                int sz = component[0];
                int edgess = component[1] / 2;

                int requiredEdges = (sz * (sz - 1) / 2);

                completeComponents += (edgess == requiredEdges) ? 1 : 0;
            }
        }

        return completeComponents;
    }
}