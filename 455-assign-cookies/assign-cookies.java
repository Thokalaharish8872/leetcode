class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int m = g.length, n = s.length;

        Arrays.sort(g);
        Arrays.sort(s);

        int content = 0;

        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){

                if(s[j] >= g[i]){
                    n--;
                    content++;
                    break;
                }
                
            }
        }

        return content;
    }
}