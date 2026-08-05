class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
            
        for(int[] invoke : invocations)
            graph[invoke[0]].add(invoke[1]);

        boolean[] isInvoked = new boolean[n];
        isInvoked[k] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(k);

        while(!q.isEmpty()){
            int u = q.poll();

            for(int v : graph[u]){

                if(!isInvoked[v]){
                    isInvoked[v] = true;

                    q.add(v);
                }
            }
        }

        boolean canRemoveAll = true;

        for(int[] invoke : invocations){
            int u = invoke[0];
            int v = invoke[1];

            if(!isInvoked[u] && isInvoked[v]){
                canRemoveAll = false;
                break;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++)
            if(!canRemoveAll || !isInvoked[i])
                ans.add(i);

        return ans;
    }
}