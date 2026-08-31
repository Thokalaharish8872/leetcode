class Solution {
    public boolean checkDivisibility(int n) {

        int num = n;
        long sum = 0, prod = 1;

        while(num > 0){
            int rem = num % 10;
            num /= 10;

            sum += rem;
            prod *= rem;
        }

        return n % (sum + prod) == 0;
    }
}