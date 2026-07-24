class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] arr = new int[n + 1][amount + 1];

        for(int i = 0; i <= n; i++)
            arr[i][0] = 0;

        for(int i = 0; i <= amount; i++)
            arr[0][i] = (int) 1e9;
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= amount; j++){
                
                int up = arr[i - 1][j];
                int left = j - coins[i - 1] >= 0 ? arr[i][j - coins[i - 1]] : (int) 1e9;

                arr[i][j] = Math.min(up, left + 1);
            }
        }

        return arr[n][amount] == (int) 1e9 ? -1 : arr[n][amount];
    }
}