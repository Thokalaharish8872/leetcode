class Solution {
    public int binaryGap(int n) {
        
        char[] chArr = Integer.toBinaryString(n).toCharArray();
        int m = chArr.length;

        int prev1 = -1;
        int maxGap = 0;

        for(int i = 0; i < m; i++){

            if(chArr[i] == '1'){
                if(prev1 != -1) maxGap = Math.max(maxGap, i - prev1);

                prev1 = i;
            }
        }

        return maxGap;
    }
}