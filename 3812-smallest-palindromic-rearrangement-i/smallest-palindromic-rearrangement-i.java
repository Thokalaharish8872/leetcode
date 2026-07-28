class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

        for(char ch : s.toCharArray())
            freq[ch - 'a']++;

        StringBuilder mid = new StringBuilder();
        StringBuilder left = new StringBuilder();

        for(int i = 0; i < 26; i++){
            char ch = (char)(i + 'a');
            
            if(freq[i] % 2 == 1)
                mid.append(ch);
            
            for(int j = 0; j < freq[i] / 2; j++)
                left.append(ch);
        }

        StringBuilder ans = new StringBuilder();
        ans.append(left);
        ans.append(mid);
        ans.append(left.reverse());

        return ans.toString();
    }
}