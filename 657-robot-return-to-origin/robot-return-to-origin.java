class Solution {
    public boolean judgeCircle(String moves) {
        int i = 0, j = 0;

        for(char move : moves.toCharArray()){
            switch(move){
                case 'L' : j -= 1; break;
                case 'R' : j += 1; break;
                case 'U' : i -= 1; break;
                case 'D' : i += 1; break;
            }
        }

        return i == 0 && j == 0 ? true : false;
    }
}