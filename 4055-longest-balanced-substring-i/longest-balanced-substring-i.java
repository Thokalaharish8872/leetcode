class Solution {
    private boolean checkStreak(int[] freq, int streak){
        
        for(int k = 0; k < 26; k++){
            
            if(freq[k] != 0 && streak == 0) streak = freq[k];
            else if(freq[k] != 0 && streak != freq[k]) return false;
        }

        return true;
    }

    public int longestBalanced(String s) {

        int n = s.length(), maxLen = 0;

        for(int i = 0; i < n; i++){

            int[] freq = new int[26];
            
            for(int j = i; j < n; j++){
                freq[s.charAt(j) - 'a']++;

                if(checkStreak(freq, 0))
                    maxLen = Math.max(maxLen, j - i + 1);
            }
        }

        return maxLen;
    }
        
}