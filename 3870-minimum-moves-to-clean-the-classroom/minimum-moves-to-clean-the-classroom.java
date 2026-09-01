class Solution {
    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length, n = classroom[0].length();
        char[][] room = new char[m][n];
        int[][] litterId = new int[m][n];
        int totalLitters = 0;

        int[] dir = new int[]{0, 1, 0, -1, 0};
        Queue<int[]> q = new LinkedList<>();

        int si = -1, sj = -1;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                room[i][j] = classroom[i].charAt(j);
                litterId[i][j] = -1;

                if(room[i][j] == 'L'){
                    litterId[i][j] = totalLitters++;
                }
                else if(room[i][j] == 'S'){
                    si = i;
                    sj = j;
                }
            }
        }

        int allMask = (1 << totalLitters) - 1;

        boolean[][][][] vis = new boolean[m][n][allMask + 1][energy + 1];

        q.add(new int[]{si, sj, 0, 0, energy});
        vis[si][sj][0][energy] = true;

        while(!q.isEmpty()){
            int sz = q.size();

            while(sz-- != 0){
                int[] curr = q.poll();
                int ci = curr[0];
                int cj = curr[1];
                int moves = curr[2];
                int mask = curr[3];
                int e = curr[4];

                if(mask == allMask)
                    return moves;
                if(e == 0)
                    continue;

                for(int k = 1; k < 5; k++){
                    int ni = ci + dir[k];
                    int nj = cj + dir[k - 1];

                    int newMask = mask;
                    int newEnergy = e - 1;

                    if(ni < 0 || ni >= m || nj < 0 || nj >= n || room[ni][nj] == 'X')
                        continue;
                    else if(room[ni][nj] == 'R')
                        newEnergy = energy;
                    else if(room[ni][nj] == 'L')
                        newMask |= (1 << litterId[ni][nj]);

                    if(vis[ni][nj][newMask][newEnergy])
                        continue;

                    vis[ni][nj][newMask][newEnergy] = true;
                    q.add(new int[]{ni, nj, moves + 1, newMask, newEnergy});
                }
            }
        }

        return -1;
    }
}