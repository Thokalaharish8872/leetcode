class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(a, b));

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                pq.add(matrix[i][j]);
            }
        }

        while(k-- != 1)
            pq.poll();
        
        return pq.peek();
    }
}