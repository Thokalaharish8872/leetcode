class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        
        for(int left = 0, right = k; right <= n; left++, right++){

            Set<Integer> set = new HashSet<>();
            for(int j = left; j < right; j++)
                set.add(nums[j]);
            
            for(int ele : set)
                map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        int max = -1;
        
        for(int key : map.keySet())
            if(map.get(key) == 1)
                max = Math.max(max, key);
        
        return max;
    }
}