// recursion + memoiation

class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] nextNext = new int[2];
        int[] next = new int[2];
        int[] curr = new int[2];

        for(int i = n - 1; i >= 0; i--){

            curr[0] = Math.max(prices[i] + nextNext[1], next[0]);
            curr[1] = Math.max(-prices[i] + next[0], next[1]);
            
            int[] temp = nextNext;
            nextNext = next;
            next = curr;
            curr = temp;
        }

        return next[1];
    }
}