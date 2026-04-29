class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] freq = new int[26];
        int f = 0;

        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
            f++;
        }

        for(char ch : t.toCharArray()){
            if(freq[ch - 'a'] <= 0) return false;
            freq[ch - 'a']--;
            f--;
        }

        
        return f == 0 ? true : false;
    }
}