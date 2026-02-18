class Solution {
    public boolean hasAlternatingBits(int n) {

        String binaryStr = Integer.toBinaryString(n);
        
        char prev = '_';
        for(char ele : binaryStr.toCharArray()){
            
            if(prev != '_' && prev == ele) return false;

            prev = ele;
        }

        return true;
    }
}