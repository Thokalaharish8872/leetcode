class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = queries.length;

        int[] ans = new int[n];

        int MOD = 1_000_000_007;

        int[][] prefix = new int[s.length() + 1][3];
        int[] powerOf10 = new int[s.length() + 1];

        powerOf10[0] = 1;

        for(int i = 1; i <= s.length(); i++){

            int num = s.charAt(i - 1) - '0';

            prefix[i][0] = num == 0 ? prefix[i - 1][0] : (int)((prefix[i - 1][0] * 10L + num) % MOD);
            prefix[i][1] = prefix[i - 1][1] + num;
            prefix[i][2] = num == 0 ? prefix[i - 1][2] : prefix[i - 1][2] + 1;

            powerOf10[i] = (int)((powerOf10[i - 1] * 10L) % MOD);
        }
        System.out.println();

        for(int i = 0; i < n; i++){
            int l = queries[i][0];
            int r = queries[i][1];

            int[] left = prefix[l];
            int[] right = prefix[r + 1];

            int len = right[2] - left[2];

            if(len == 0){
                ans[i] = 0;
                continue;
            }

            long rem = (1L * left[0] * powerOf10[len]) % MOD;
            long concat = (right[0] - rem + MOD) % MOD;

            int sum = right[1] - left[1];

            ans[i] = (int)((concat * sum) % MOD);
        }

        return ans;
    }
}