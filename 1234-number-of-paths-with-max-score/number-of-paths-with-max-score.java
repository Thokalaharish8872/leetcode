class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1_000_000_007;

        int[] dx = new int[]{-1, 0, -1};
        int[] dy = new int[]{0, -1, -1};

        int maxSum = 0;
        int freq = 0;

        int[][] score = new int[n][n];
        int[][] ways = new int[n][n];
        ways[0][0] = 1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){

                if(i == 0 && j == 0)
                    continue;

                char ch = board.get(i).charAt(j);
                if(ch == 'X')
                    continue;

                int currCellVal = ch - '0';
                if(ch == 'E' || ch == 'S')
                    currCellVal = 0;
                
                int maxPrevScore = -1;
                int totalWays = 0;

                for(int k = 0; k < 3; k++){
                    int ni = i + dx[k];
                    int nj = j + dy[k];

                    if(ni >= 0 && nj >= 0 && ways[ni][nj] != 0){
                        if(score[ni][nj] > maxPrevScore){
                            maxPrevScore = score[ni][nj];
                            totalWays = ways[ni][nj];
                        }
                        else if(score[ni][nj] == maxPrevScore){
                            totalWays = (totalWays + ways[ni][nj]) % MOD;
                        }
                    }
                }
                if(maxPrevScore != -1){  
                    score[i][j] = maxPrevScore + currCellVal;
                    ways[i][j] = totalWays;
                }
                
            }
        }

        return new int[]{score[n - 1][ n - 1], ways[n - 1][n - 1]};
    }
}