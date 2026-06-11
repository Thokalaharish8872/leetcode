class Solution {
    private void f(int n, List<String> l, String s, int open, int close){
        if(s.length() == n * 2)
            l.add(s);
        
        if(open < n) 
            f(n, l, s + "(", open + 1, close);

        if(close < open)
            f(n, l, s + ")", open, close + 1);
    }
    public List<String> generateParenthesis(int n) {
        List<String> l = new ArrayList<>();
        f(n, l, "", 0, 0);

        return l;
    }
}