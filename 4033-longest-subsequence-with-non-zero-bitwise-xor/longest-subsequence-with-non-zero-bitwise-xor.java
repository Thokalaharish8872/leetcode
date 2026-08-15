class Solution {
    public int longestSubsequence(int[] nums) {
        int ans = 0;
        boolean allZeros = true;
        
        for(int num : nums){
            ans ^= num;
            if(num != 0) allZeros = false;
        }

        if(nums.length == 0 || allZeros) return 0;
        
        if(ans == 0) return nums.length-1;
        return nums.length;
    }
}