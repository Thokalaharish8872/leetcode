class Solution {
    public int minPartitions(String n) {
        
        int maxNum = Integer.MIN_VALUE;

        for(char ch : n.toCharArray()){
            maxNum = Math.max(maxNum, ch - '0');
        }

        return maxNum;
    }
}