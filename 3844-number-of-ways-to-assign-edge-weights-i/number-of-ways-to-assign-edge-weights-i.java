class Solution {
    private int power(int depth){
        int MOD = 100_000_000_7;

        long ans = 1;
        long base = 2;
        long exp = depth - 1;

        while(exp > 0){
            if((exp & 1) == 1)
                ans = (ans * base) % MOD;
            
            base = (base * base) % MOD;
            exp >>= 1;
        }

        return (int)ans;
    }
    private void getDepth(List<Integer>[] graph, int[] dp, int i, int depth) {
        if(dp[i] != -1)
            return;

        dp[i] = depth;

        for(int node : graph[i]){
            getDepth(graph, dp, node, depth + 1);
        }
    }

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] graph = new ArrayList[n + 1];
        int[] dp = new int[n + 1];

        for(int i = 1 ; i <= n; i++){
            graph[i] = new ArrayList<>();
            dp[i] = -1;
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        getDepth(graph, dp, 1, 0);
        int depth = 0;

        for(int i = 1; i <= n; i++){
            depth = Math.max(depth, dp[i]);
        }

        return power(depth);
    }
}