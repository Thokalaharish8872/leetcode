class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i = 0, j = n - 1; i <= j; i++, j--){

            int complement = target - nums[i];
            int complement2 = target - nums[j];

            if(complement + complement2 == target && i != j) return new int[]{i, j};

            if(map.containsKey(complement)) return new int[]{i, map.get(complement)};
            else if(map.containsKey(complement2)) return new int[]{map.get(complement2), j};

            map.put(nums[i], i);
            map.put(nums[j], j);
        }

        return new int[2];
    }
}