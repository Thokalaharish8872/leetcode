class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {

        long MOD = 1_000_000_007;

        for(int[] query : queries){
            int l = query[0];
            int r = query[1];
            int k = query[2];
            int v = query[3];

            while(l <= r){
                nums[l] = (int)((1L * nums[l] * v % MOD) % MOD);
                l += k;
            }
        }

        for(int i = 1; i < nums.length; i++){
            nums[i] = nums[i] ^ nums[i - 1];
        }

        return nums[nums.length - 1];
    }
}