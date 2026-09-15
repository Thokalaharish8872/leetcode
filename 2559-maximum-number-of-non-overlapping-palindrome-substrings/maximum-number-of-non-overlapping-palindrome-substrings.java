class Solution {
    private int isPalindrome(String s, int[][] pal, int i, int j){
        if(i >= j)
            return 1;

        if(pal[i][j] != -1)
            return pal[i][j];

        pal[i][j] = 0;

        if(s.charAt(i) == s.charAt(j))
            pal[i][j] = isPalindrome(s, pal, i + 1, j - 1);

        return pal[i][j];
    }

    private int f(String s, int[][] pal, int[] dp, int i, int k, int n){
        if(i >= n)
            return 0;

        if(dp[i] != -1)
            return dp[i];

        int ans = f(s, pal, dp, i + 1, k, n);

        for(int j = i + k - 1; j < n; j++){
            if(isPalindrome(s, pal, i, j) == 1){
                ans = Math.max(ans, 1 + f(s, pal, dp, j + 1, k, n));
            }
        }

        return dp[i] = ans;
    }
    public int maxPalindromes(String s, int k) {

        int n = s.length();
        int count = 0;

        int[][] pal = new int[n][n];
        for(int[] lap : pal)
            Arrays.fill(lap, -1);

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return f(s, pal, dp, 0, k, n);
    }
}