class Solution {
    public int minimumDeletions(String s) {
        int del = 0, bCount = 0;

        for(char ch : s.toCharArray()){

            if(ch == 'b') bCount++;
            else if(bCount != 0){
                
                del++;
                bCount--;
            }
        }

        return del;
    }
}