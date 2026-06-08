class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] res = new int[n];

        int idx = 0;
        for(int k = 0; k < 3; k++){
            for(int i = 0; i < n; i++){
                if((k == 0 && nums[i] < pivot) || 
                    (k == 1 && nums[i] == pivot) || 
                        (k == 2 && nums[i] > pivot))
                    res[idx++] = nums[i];
            }
        }

        return res;
    }
}