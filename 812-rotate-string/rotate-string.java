class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        if(n != goal.length()) return false;
        if(s.equals(goal)) return true;

        StringBuilder sb = new StringBuilder(s);

        for(int i = 0; i < n; i++){
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);

            if(goal.equals(sb + "")) return true;
        }

        return false;
    }
}