class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        for(int i = 0; i < k; i++){
            pq.add(new int[]{i, nums[i]});
        }

        int[] ans = new int[n - k + 1];

        for(int i = 0, j = k - 1; j < n; i++, j++){
            pq.add(new int[]{j, nums[j]});

            while(pq.peek()[0] < i){
                pq.remove();
            }

            ans[i] = pq.peek()[1];
        }

        return ans;
    }
}