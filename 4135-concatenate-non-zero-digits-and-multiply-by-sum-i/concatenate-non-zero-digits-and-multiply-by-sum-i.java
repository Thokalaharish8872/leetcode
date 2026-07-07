class Solution {
    public long sumAndMultiply(int n) {
        int num = 0;
        long sum = 0;
        double len = 10.0;

        while(n > 0){
            int rem = n % 10;
            n /= 10;

            if(rem == 0)
                continue;
            
            if(num == 0){
                num = rem;
                sum = rem;
                continue;
            }

            double moveFront = num / len;
            double addRem = moveFront + rem;
            double moveBack = Math.round(addRem * len);

            num = (int) moveBack;
            sum += rem;

            len *= 10;
        }

        return num * sum;
    }
}