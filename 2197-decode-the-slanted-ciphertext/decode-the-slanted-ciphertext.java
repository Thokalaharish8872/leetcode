class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if(rows == 1) return encodedText;
        int len = encodedText.length(), n = len / rows;
        char[][] grid = new char[rows][n];

        int k = 0;
        for(int i = 0; i < rows && k < len; i++)
            for(int j = 0; j < n && k < len; j++)
                grid[i][j] = encodedText.charAt(k++);

        StringBuilder s = new StringBuilder();
        for(int j = 0; j < n; j++)
            for(int i = 0; i < rows && (j + i) <n ; i++)
                s.append(grid[i][j + i]);

        String res = s.toString();
        for(int i = res.length() - 1; i >= 0; i--)
            if(res.charAt(i) != ' ') return res.substring(0, i + 1);
        
        return res;
    }
}