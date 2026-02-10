class Solution {
    public int longestBalanced(int[] nums) {
        
        int n = nums.length, bal = 0;

        for(int i = 0; i < n; i++){
            HashSet<Integer> even = new HashSet<>();
            HashSet<Integer> odd = new HashSet<>();

            for(int j = i; j < n; j++){
                if((nums[j] & 1) == 0) even.add(nums[j]);
                else odd.add(nums[j]);

                if(even.size() == odd.size()) bal = Math.max(bal, j - i + 1);
            } 
        }

        return bal;
    }
}