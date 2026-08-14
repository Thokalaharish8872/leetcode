class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int[] freq = new int[26];

        int maxLen = 0;
        for(int i = 0, j = 0; j < n; j++){
            
            int ascii = s.charAt(j) - 'a';
            freq[ascii]++;

            while(i <= j && freq[ascii] > 2)
                freq[s.charAt(i++) - 'a']--;

            int len = j - i + 1;
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}