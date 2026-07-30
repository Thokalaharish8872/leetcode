class Solution {
    public int minimumPushes(String word) {
        
        int n = word.length();
        int clicks = 1;
        int pushes = 0;

        while(n > 0){
            
            int rem = n > 8 ? n - 8 : 0;

            pushes += (n - rem) * clicks;

            n -= 8;
            clicks++;
        }

        return pushes;
    }
}