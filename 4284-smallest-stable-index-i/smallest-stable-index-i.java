class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int[] prefix = new int[n], suffix = new int[n];
        prefix[0] = nums[0];
        suffix[n - 1] = nums[n - 1];

        for(int i = 1, j = n - 2; i < n && j >= 0; i++, j--){
            prefix[i] = Math.max(prefix[i - 1], nums[i]);
            suffix[j] = Math.min(suffix[j + 1], nums[j]);
        }

        for(int i = 0; i < n; i++){

            if(prefix[i] - suffix[i] <= k)
                return i;
        }

        return -1;
    }
}