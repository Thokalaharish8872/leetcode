class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n; i++){
            int j = i;

            while(j < n && nums[j] == 0) j++;
            
            if(i == j || j == n)
                continue;

            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }
}