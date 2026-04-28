class Solution {
    public int minOperations(int[][] grid, int x) {

        int m = grid.length, n = grid[0].length;
        if(m == 1 && n == 1) return 0;

        int[] arr = new int[m * n];
        int k = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                arr[k++] = grid[i][j];
            }
        }

        Arrays.sort(arr);
        int mid = arr.length / 2;
        int minSteps = Integer.MAX_VALUE;

        for(int i = 0; i < 2; i++){
            int steps = 0;

            for(k = 0; k < m * n; k++){
                int dis = Math.abs(arr[mid] - arr[k]);

                if(dis % x != 0){
                    steps = Integer.MAX_VALUE;
                    break;
                }
                steps +=  dis/ x;
            }

            minSteps = Math.min(minSteps, steps);
            mid--;
        }

        return minSteps == Integer.MAX_VALUE ? -1 : minSteps;
    }
}