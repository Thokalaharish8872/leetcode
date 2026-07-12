class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int[] rank = new int[n];

        for(int i = 0; i < n; i++)
            pq.add(new int[]{arr[i], i});

        int pVal = 1_000_000_007;
        int k = 0;

        while(!pq.isEmpty()){
            int[] a = pq.poll();
            int val = a[0];
            int idx = a[1];

            if(pVal != val)
                k++;

            rank[idx] = k;
            pVal = val;
        }

        return rank;
    }
}