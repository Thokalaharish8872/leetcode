class Solution {
    public int largestAltitude(int[] gain) {
        
        int sum = 0, maxGain = 0;

        for(int g : gain){
            sum += g;
            maxGain = Math.max(maxGain, sum);
        }

        return maxGain;
    }
}