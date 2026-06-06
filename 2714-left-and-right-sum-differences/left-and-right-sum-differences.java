class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;

        int[] prefix = new int[n];
        int[] postfix = new int[n];

        for(int i = 1, j = n - 2; i < n && j >= 0; i++, j--){
            prefix[i] = nums[i - 1] + prefix[i - 1];
            postfix[j] = nums[j + 1] + postfix[j + 1];
        }

        int[] res = new int[n];

        for(int i = 0; i < n; i++){
            res[i] = Math.abs(prefix[i] - postfix[i]);
        }

        return res;
    }
}