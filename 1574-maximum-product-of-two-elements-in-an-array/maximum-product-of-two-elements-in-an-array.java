class Solution {
    public int maxProduct(int[] nums) {
        int max1 = 0, max2 = 0;

        for(int num : nums){
            if(num > max1){
                max2 = max1;
                max1 = num - 1;
            }
            else if(num > max2)
                max2 = num - 1;
        }

        return max1 * max2;
    }
}