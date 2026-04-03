class Solution {
    public int minimumEffortPath(int[][] heights) {

        int m = heights.length, n = heights[0].length;
        int[] dir = new int[]{0, 1, 0, -1, 0};
        int[][] effort = new int[m][n];
        for(int[] e : effort){
            Arrays.fill(e, (int)1e9);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });
        effort[0][0] = 0;
        pq.add(new int[]{0, 0, 0});

        while(!pq.isEmpty()){
            int[] prev = pq.remove();
            int e = prev[0];
            int previ = prev[1];
            int prevj = prev[2];
            int maxDiff = 0;

            for(int k = 1; k < 5; k++){
                int curri = previ + dir[k];
                int currj = prevj + dir[k - 1];

                if(curri >= 0 && curri < m && currj >=0 && currj < n){
                    int diff = Math.abs(heights[previ][prevj] - heights[curri][currj]);
                    
                    int newEffort = Math.max(e, diff);
    
                    if(newEffort < effort[curri][currj]){
                        effort[curri][currj] = newEffort;

                        pq.add(new int[]{newEffort, curri, currj});
                    }
                }
            }
        }

        return effort[m - 1][n - 1];
    }
}