class Solution {
    private void f(int n, String s, List<String> list, int open, int close){
        if(s.length() == n * 2){
            list.add(s);
            return;
        }

        if(open < n)
            f(n, s + "(", list, open + 1, close);
        if(close < open)
            f(n, s + ")", list, open, close + 1);
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        f(n, "", list, 0, 0);
        return list;
    }
}