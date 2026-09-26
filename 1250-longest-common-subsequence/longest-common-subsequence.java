class Solution {
    private int f(String text1, String text2, int[][] dp, int i, int j){
        if(i == text1.length() || j == text2.length())
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        if(text1.charAt(i) == text2.charAt(j))
            return dp[i][j] = 1 + f(text1, text2, dp, i + 1, j + 1);

        return dp[i][j] = Math.max(f(text1, text2, dp, i + 1, j), f(text1, text2, dp, i, j + 1));
        
    }
    public int longestCommonSubsequence(String text1, String text2) {
        
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] d : dp)
            Arrays.fill(d, -1);

        return f(text1, text2, dp, 0, 0);
    }
}