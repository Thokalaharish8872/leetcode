class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] flight : flights){
            adj.get(flight[0]).add(new int[]{flight[2], flight[1]});
        }

        int[][] price = new int[n][k + 2];
        for(int[] p : price){
            Arrays.fill(p, (int)1e9);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });

        price[src][0] = 0;
        pq.add(new int[]{0, 0, src});

        while(!pq.isEmpty()){
            int[] prev = pq.remove();
            int p = prev[0];
            int stops = prev[1];
            int node = prev[2];

            if(node == dst) return p;
            if(stops > k) continue;

            for(int[] neig : adj.get(node)){

                if(p + neig[0] < price[neig[1]][stops + 1]){
                    price[neig[1]][stops + 1] = p + neig[0]; 

                    pq.add(new int[]{p + neig[0], stops + 1, neig[1]});
                }
            }
        }

        return -1;
    }
}