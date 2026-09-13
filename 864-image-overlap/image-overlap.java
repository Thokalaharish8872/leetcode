class Solution {

    // private int moveUp(int[][] img1, int[][] img2, int[][][][] dp, int n, int up, int right, int down, int left){
    //     if(up >= n)
    //         return 0;

    //     int[][] img = new int[n][n];

    //     for(int i = 1; i < n; i++){
    //         for(int j = 0; j < n; j++){
    //             img[i - 1][j] = img1[i][j];
    //         }
    //     }

    //     return f(img, img2, dp, n, up + 1, right, down, left, 0);
    // }

    // private int moveRight(int[][] img1, int[][] img2, int[][][][] dp, int n, int up, int right, int down, int left){
    //     if(right >= n)
    //         return 0;

    //     int[][] img = new int[n][n];

    //     for(int i = 0; i < n; i++){
    //         for(int j = n - 2; j >= 0; j--){
    //             img[i][j + 1] = img1[i][j];
    //         }
    //     }

    //     return f(img, img2, dp, n, up, right + 1, down, left, 0);

    // }

    // private int moveDown(int[][] img1, int[][] img2, int[][][][] dp, int n, int up, int right, int down, int left){
    //     if(down >= n)
    //         return 0;

    //     int[][] img = new int[n][n];

    //     for(int i = n - 2; i >= 0; i--){
    //         for(int j = 0; j < n; j++){
    //             img[i + 1][j] = img1[i][j];
    //         }
    //     }

    //     return f(img, img2, dp, n, up, right, down + 1, left, 0);

    // }

    // private int moveLeft(int[][] img1, int[][] img2, int[][][][] dp, int n, int up, int right, int down, int left){
    //     if(left >= n)
    //         return 0;

    //     int[][] img = new int[n][n];

    //     for(int i = 0; i < n; i++){
    //         for(int j = 1; j < n; j++){
    //             img[i][j - 1] = img1[i][j];
    //         }
    //     }

    //     return f(img, img2, dp, n, up, right, down, left + 1, 0);
    // }


    private int f(int[][] img1, int[][] img2, int[][] dp, int n, int up, int right, int down, int left){

        if(up < 0 || up >= n || right < 0 || right >= n || down < 0 || down >= n || left < 0 || left >= n)
            return 0;

        int rowShift = down - up;
        int colShift = right - left;

        int row = rowShift + n - 1;
        int col = colShift + n - 1;

        if(dp[row][col] != -1)
            return dp[row][col];

        int overlap = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){

                int nextRow = i + rowShift;
                int nextCol = j + colShift;

                if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n)
                    continue;

                if(img1[nextRow][nextCol] == 1 && img2[i][j] == 1)
                    overlap++;
            }
        }

        overlap = Math.max(overlap, f(img1, img2, dp, n, up + 1, right, down, left));    
        overlap = Math.max(overlap, f(img1, img2, dp, n, up, right + 1, down, left));    
        overlap = Math.max(overlap, f(img1, img2, dp, n, up, right, down + 1, left));    
        overlap = Math.max(overlap, f(img1, img2, dp, n, up, right, down, left + 1));     

        return dp[row][col] = overlap;  
    }
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        int[][] dp = new int[2 * n][2 * n];
        for(int[] d : dp)
            Arrays.fill(d, -1);

        return f(img1, img2, dp, n, 0, 0, 0, 0);
    }
}