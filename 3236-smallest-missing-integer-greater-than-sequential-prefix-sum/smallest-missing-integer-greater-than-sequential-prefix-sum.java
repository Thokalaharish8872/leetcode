class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;

        boolean[] isPresent = new boolean[51];

        for(int i = 0; i < n; i++)
            isPresent[nums[i]] = true;
        
        int prefix = nums[0];
        int j = 1;

        while(j < n && nums[j] == nums[j - 1] + 1)
            prefix += nums[j++];
        
        while(prefix <= 50 && isPresent[prefix])
            prefix++;
        
        return prefix;
    }
}