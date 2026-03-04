class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        int[] row = new int[m];
        int[] rowCol = new int[m];
        int[] col = new int[n];

        int spec = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1){
                    row[i]++;
                    rowCol[i] = j;

                    col[j]++;
                }
            }
        }

        for(int i = 0; i < m; i++){
            if(row[i] == 1 && col[rowCol[i]] == 1) spec++; 
        }

        return spec;
    }
}