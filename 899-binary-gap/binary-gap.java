class Solution {
    public int binaryGap(int n) {

        int prev1 = -1, curr = 0;
        int maxGap = 0;

        while(n > 0){

            int bit = n & 1;

            if(bit == 1){
                if(prev1 != -1) maxGap = Math.max(maxGap, curr - prev1);

                prev1 = curr;
            }

            n = n >> 1;
            curr++;
        }

        return maxGap;
    }
}