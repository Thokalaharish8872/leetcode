class Solution {
    int[] prefix;

    private void preCompute(){
        prefix = new int[20001];

        prefix[1] = 1;
        prefix[2] = 2;

        for(int i = 3; i <= 2000; i++){
            prefix[i] = i + prefix[i - 2];
        }
    }

    private int gcd(int a, int b){
        while(b > 0){
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public int gcdOfOddEvenSums(int n) {
        
        if(prefix == null)
            preCompute();

        return gcd(prefix[2 * n], prefix[2 * n - 1]);
    }
}