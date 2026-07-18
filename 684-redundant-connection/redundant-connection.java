class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        UFDS dis = new UFDS(n + 1);

        int[] ans = new int[2];

        for(int[] edge : edges){
            if(!dis.union(edge[0], edge[1])){
                ans = edge;
            }
        }

        return ans;
    }
}

class UFDS{
    int[] parent;
    
    public UFDS(int n){
        parent = new int[n];

        for(int x = 0; x < n; x++)
            parent[x] = x;
    }

    public int find(int x){
        if(parent[x] == x)
            return x;
        
        return parent[x] = find(parent[x]);
    }

    public boolean union(int x, int y){
        int xParent = find(x), yParent = find(y);

        if(xParent == yParent)
            return false; // cycle exists
        
        parent[yParent] = xParent; // cycle doesn't exist
        return true;
    }
}