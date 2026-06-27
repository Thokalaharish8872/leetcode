class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        int maxSubset = 0;
        int oneSize = map.getOrDefault(1, 0);

        if(oneSize % 2 == 1)
            maxSubset = oneSize;
        else
            maxSubset = oneSize - 1;

        for(int key : map.keySet()){

            if(key == 1)
                continue;

            int subset = 0;
            while(map.getOrDefault(key, 0) >= 2){
                subset += 2;
                if(key > 46340){
                    key = Integer.MAX_VALUE;
                    break;
                }
                
                key *= key;
            }
            if(map.containsKey(key))
                subset++;
            else
                subset--;
            
            maxSubset = Math.max(maxSubset, subset);
        }

        return maxSubset;
    }
}