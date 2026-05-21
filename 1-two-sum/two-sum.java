class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0, j = nums.length - 1; i <= j; i++, j--){
            
            int c1 = target - nums[i];
            int c2 = target - nums[j];

            if(nums[i] + nums[j] == target && i != j)
                return new int[]{i, j};

            if(map.containsKey(c1))
                return new int[]{i, map.get(c1)};
            if(map.containsKey(c2))
                return new int[]{j, map.get(c2)};
            
            map.put(nums[i], i);
            map.put(nums[j], j);
        }

        return new int[]{-1, -1};
    }
}