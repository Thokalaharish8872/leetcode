class Solution {
    private String getLCS(String str1, String str2, int n, int m){
        String[] prev = new String[m + 1];
        String[] curr = new String[m + 1];

        for(int i = 0; i <= m; i++)
            prev[i] = "";

        curr[0] = "";

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){

                if(str1.charAt(i - 1) == str2.charAt(j - 1))
                    curr[j] = prev[j - 1] + str1.charAt(i - 1);
                else
                    curr[j] = curr[j - 1].length() > prev[j].length() ? curr[j - 1] : prev[j];
            }

            String[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[m];
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        String LCS = getLCS(str1, str2, n, m);
        int sz = LCS.length();
        int k = 0;

        String ans = "";
        int i = 0, j = 0;

        while(k < sz){
            while(i < n && str1.charAt(i) != LCS.charAt(k)){
                ans = ans + str1.charAt(i);
                i++;
            }

            while(j < m && str2.charAt(j) != LCS.charAt(k)){
                ans = ans + str2.charAt(j);
                j++;
            }

            ans = ans + LCS.charAt(k);
            i++;
            j++;
            k++;
        }

        return ans + str1.substring(i) + str2.substring(j);
    }
}