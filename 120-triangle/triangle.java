
// tabulation with space optimize
class Solution {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();

        int[] dp;
        int[] temp = new int[m];

        for(int i = m - 1; i >= 0; i--){
            dp = temp;
            temp = new int[i + 1];

            for(int j = i; j >= 0; j--){

                temp[j] = triangle.get(i).get(j);

                if(i == m - 1)
                    continue;

                int down = dp[j];
                int downRight = dp[j + 1];

                temp[j] += Math.min(down, downRight);
            }
        }

        return temp[0];
    }
}