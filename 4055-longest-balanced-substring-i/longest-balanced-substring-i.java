class Solution {
    private boolean checkStreak(int[] alps, int streak){
        
        for(int k = 0; k < 26; k++){
            
            if(alps[k] != 0 && streak == 0) streak = alps[k];
            else if(alps[k] != 0 && streak != alps[k]) return false;
        }

        return true;
    }

    public int longestBalanced(String s) {

        int n = s.length(), len = 0;

        for(int i = 0; i < n; i++){
            int[] alps = new int[26];
            
            for(int j = i; j < n; j++){
                alps[s.charAt(j) - 'a']++;

                if(checkStreak(alps, 0))
                    len = Math.max(len, j - i + 1);
            }
        }

        return len;
    }
        
}