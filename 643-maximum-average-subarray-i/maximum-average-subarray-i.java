class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }

        double maxSum = sum;
        System.out.println(sum + " " + maxSum);

        for(int i = k; i < nums.length; i++){
            sum = (sum - nums[i - k]) + nums[i];
            maxSum = Math.max(maxSum, sum);

            System.out.println(sum + " " + maxSum);
        }

        return maxSum/k;
    }
}