class Solution {
    private int getWeight(int[] u, int[] v){
        return Math.abs(u[0] - v[0]) + Math.abs(u[1] - v[1]);
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        List<Edge> edges = new ArrayList<>();

        for(int u = 0; u < n - 1; u++){
            for(int v = u + 1; v < n; v++){

                int wt = getWeight(points[u], points[v]);
                edges.add(new Edge(u, v,  wt));
            }
        }

        Collections.sort(edges, (v1, v2) -> Integer.compare(v1.wt, v2.wt));

        UFDS dis = new UFDS(n);

        int mstCost = 0;
        int selected = 0;

        for(Edge edge : edges){
            if(dis.union(edge.u, edge.v)){
                mstCost += edge.wt;
                selected++;
            }

            if(selected == n - 1)
                break;
        }

        return mstCost;
    }
}

class Edge{
    int u, v, wt;
    
    public Edge(int u, int v, int wt){
        this.u = u;
        this.v = v;
        this.wt = wt;
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
        if(x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    public boolean union(int x, int y){
        int parentX = find(x);
        int parentY = find(y);

        if(parentX == parentY)
            return false; //cycle exist
        
        parent[parentY] = parentX; //cycle Doesn't exist
        return true;
    }
}