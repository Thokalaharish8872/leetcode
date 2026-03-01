class Solution {
    public int minPartitions(String n) {
        
        int maxI = Integer.MIN_VALUE, maxJ = maxI;

        for(int i = 0, j = n.length() - 1; i <= j; i++, j--){
            maxI = Math.max(maxI, n.charAt(i) - '0');
            maxJ = Math.max(maxJ, n.charAt(j) - '0');
        }

        return Math.max(maxI, maxJ);
    }
}