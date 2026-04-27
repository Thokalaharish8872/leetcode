class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int st = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] != 0){
                nums[st++] = nums[i];
            }
        }

        for(int i = n - 1; i >= st; i--) nums[i] = 0;
    }
}