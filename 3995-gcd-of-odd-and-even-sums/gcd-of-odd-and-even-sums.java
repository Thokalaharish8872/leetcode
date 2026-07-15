class Solution {

    private int gcd(int a, int b){
        while(b > 0){
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public int gcdOfOddEvenSums(int n) {
        
        int sumOdd = 0;
        int sumEven = 0;

        do{
            sumOdd += (2 * n - 1);
            sumEven += (2 * n);

            System.out.println(sumOdd + " " + sumEven);
        }
        while(n-- > 1);

        return gcd(sumOdd, sumEven);
    }
}