class Solution {
    
    public int uniquePaths(int m, int n) {
        int[] dp;
        int[] temp = new int[n];

        for(int i = 0; i < m; i++){
            dp = temp;
            temp = new int[n];
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    temp[j] = 1;
                    continue;
                }
                temp[j] = dp[j] + ((j == 0) ? 0 : temp[j - 1]);
            }
        }

        return temp[n - 1];
    }
}