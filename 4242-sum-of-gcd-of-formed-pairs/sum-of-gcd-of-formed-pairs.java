class Solution {
    private int gcd(int a, int b){
        while(b > 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public long gcdSum(int[] nums) {
        int n = nums.length;

        int[] prefixGcd = new int[n];
        prefixGcd[0] = nums[0];

        int max = nums[0];

        for(int i = 1; i < n; i++){
            max = Math.max(max, nums[i]);

            // if(max != nums[i])
                prefixGcd[i] = gcd(max, nums[i]);
            // else
            //     prefixGcd[i] = nums[i];
        }

        Arrays.sort(prefixGcd);

        long sum = 0;

        for(int i = 0, j = n - 1; i < j; i++, j--)
            sum += gcd(prefixGcd[i], prefixGcd[j]);

        return sum;
    }
}