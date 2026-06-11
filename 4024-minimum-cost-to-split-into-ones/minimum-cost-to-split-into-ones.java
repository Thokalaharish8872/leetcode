class Solution {
    public int minCost(int n) {
        int sum = 0;

        while(n > 0){
            n -= 1;
            sum += n;
        }

        return sum;
    }
}