
// recursion
class Solution {
    private int dfs(List<List<Integer>> triangle, int[][] dp, int m, int i, int j){
        if(i == m)
            return 0;
        
        if(j > i)
            return Integer.MAX_VALUE;
        
        if(dp[i][j] != Integer.MAX_VALUE)
            return dp[i][j];

        return dp[i][j] = triangle.get(i).get(j) + 
                            Math.min(
                                dfs(triangle, dp, m, i + 1, j),
                                dfs(triangle, dp, m, i + 1, j + 1)
                            );

    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();

        int[][] dp = new int[m][];

        for(int i = 0; i < m; i++)
            dp[i] = new int[triangle.get(i).size()];
        
        for(int[] d : dp)
            Arrays.fill(d, Integer.MAX_VALUE);

        return dfs(triangle, dp, m, 0, 0);
    }
}