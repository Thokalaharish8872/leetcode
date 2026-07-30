class Solution {
    private int f(char[] vowels, int[][] dp, int n, int idx){
        if(n == 0)
            return 1;

        if(dp[n][idx] != -1)
            return dp[n][idx];

        int count = 0;
        for(int j = idx; j < 5; j++)
            count += f(vowels, dp, n - 1, j);
        
        return dp[n][idx] = count;
    }
    public int countVowelStrings(int n) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        int[][] dp = new int[n + 1][5];
        for(int[] d : dp)
            Arrays.fill(d, -1);;

        return f(vowels, dp, n, 0);
    }
}