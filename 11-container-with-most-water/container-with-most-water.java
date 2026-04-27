class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxWater = 0;

        while(left < right){
            int min = Math.min(height[left], height[right]);
            int dis = right - left;
            int water = dis * min;

            maxWater = Math.max(maxWater, water);

            if(min == height[right]) right--;
            else left++;
        }

        return maxWater;
    }
}