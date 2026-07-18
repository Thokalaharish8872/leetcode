class Solution {
    private int gcd(int a, int b){
        while(b > 0){
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
    public int findGCD(int[] nums) {
        int min = 10001;
        int max = 0;

        for(int num : nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return gcd(min, max);
    }
}