class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int s = 0;
        int b = 0;

        for(char move : moves.toCharArray()){
            if(move == 'L') s--;
            else if(move == 'R') s++;
            else b++;
        }

        return Math.abs(s) + b;
    }
}