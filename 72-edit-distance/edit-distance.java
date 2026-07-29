class Solution {
    private int f(String s1, String s2, int[][] dp, int i, int j){
        if(j == -1)
            return i + 1;
        if(i == -1)
            return j + 1;

        if(dp[i][j] != -1)
            return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = f(s1, s2, dp, i - 1, j - 1);

        int insert = f(s1, s2, dp, i, j - 1);
        int delete = f(s1, s2, dp, i - 1, j);
        int replace = f(s1, s2, dp, i - 1, j - 1);

        return dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();

        int[][] dp = new int[m][n];
        for(int[] d : dp)
            Arrays.fill(d, -1);

        return f(word1, word2, dp, m - 1, n - 1);
    }
}