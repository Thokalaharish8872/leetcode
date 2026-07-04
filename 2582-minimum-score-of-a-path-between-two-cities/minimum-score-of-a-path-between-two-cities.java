class Solution {
    public int minScore(int n, int[][] roads) {

        int min = Integer.MAX_VALUE;

        List<int[]>[] graph = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            int dis = road[2];

            graph[u].add(new int[]{v, dis});
            graph[v].add(new int[]{u, dis});
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        boolean[] vis = new boolean[n + 1];

        while(!q.isEmpty()){
            int sz = q.size();

            while(sz-- != 0){
                int u = q.poll();
                
                for(int[] g : graph[u]){

                    int v = g[0];
                    int d = g[1];

                    min = Math.min(min, d);

                    if(!vis[v]){
                        vis[v] = true;
                        q.add(v);
                    }
                }
            }
        }   

        return min;
    }
}