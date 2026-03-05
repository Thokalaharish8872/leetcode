class Solution {
    public int minOperations(String s){
        boolean stOne = true;
        boolean stZero = true;

        int stOneCount = 0;
        int stZeroCount = 0;;

        for(char ch : s.toCharArray()){
            if((ch == '0' && !stOne) || (ch == '1' && stOne)) stOneCount++;
            if((ch == '0' && stZero) || (ch == '1' && !stZero)) stZeroCount++;

            stOne = !stOne;
            stZero = !stZero;
        }

        return Math.min(stZeroCount, stOneCount);
    }
}