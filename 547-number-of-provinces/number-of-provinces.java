class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UFDS dis = new UFDS(n);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j && isConnected[i][j] == 1)
                    dis.union(i, j);
            }
        }

        return dis.n;
    }
}

class UFDS{
    int[] parent;
    int n;

    public UFDS(int n){
        this.n = n;
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
        int parentX = find(x), parentY = find(y);

        if(parentX == parentY)
            return false; // cycle exist
        
        n--;
        parent[parentY] = parentX; // cycle doesn't exist
        return true;
    }
}