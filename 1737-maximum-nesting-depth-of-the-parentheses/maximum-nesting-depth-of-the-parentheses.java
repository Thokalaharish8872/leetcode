class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        int maxDepth = 0;

        for(char ch : s.toCharArray()){
            if(ch == '(')
                depth++;
            else if(ch == ')')
                depth--;
            
            maxDepth = Math.max(maxDepth, depth);
        }

        return maxDepth;
    }
}