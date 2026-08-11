
class Solution {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        List<Integer> ans = new ArrayList<>();
        ans.add(nums[0]);

        int k = 1;

        for(int i = 1; i < n; i++){
            if(nums[i] > ans.get(k - 1)){
                ans.add(nums[i]);
                k++;
            }
            else{
                int ceil = -Collections.binarySearch(ans, nums[i]) - 1;

                if(ceil >= 0)
                    ans.set(ceil, nums[i]);
            }
        }
        
        return k;
    }
}