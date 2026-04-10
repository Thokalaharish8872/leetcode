class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int minDis = (int)1e9;

        for(int i = 0; i < nums.length; i++){
            ArrayList<Integer> idx = map.getOrDefault(nums[i], new ArrayList<>());
            idx.add(i);
            map.put(nums[i], idx);
        }

        for(int key : map.keySet()){
            ArrayList<Integer> idx = map.get(key);
            int n = idx.size();

            for(int i = 0; i < n; i++){
                for(int j = i + 1; j < n; j++){
                    for(int k = j + 1; k < n; k++){
                        int dis = Math.abs(idx.get(i) - idx.get(j)) + 
                            Math.abs(idx.get(j) - idx.get(k)) + Math.abs(idx.get(k) - idx.get(i));
                        
                        minDis = Math.min(minDis, dis);
                    }
                }
            }
        }

        return minDis != (int)1e9 ? minDis : -1;
    }
}