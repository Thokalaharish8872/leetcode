class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];

        for(char ch : text.toCharArray()){
            freq[ch - 'a']++;
        }

        int b = freq[1];
        int a = freq[0];
        int l = freq[11] /= 2;
        int o = freq[14] /= 2;
        int n = freq[13];
        
        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
    }
}