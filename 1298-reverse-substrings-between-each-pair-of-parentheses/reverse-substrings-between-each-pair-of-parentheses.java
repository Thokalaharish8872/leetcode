class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<String> st = new Stack<>();
        int count = 0;

        for(int i = 0; i <= n; i++){
            
            while(i < n && s.charAt(i) != ')'){
                if(s.charAt(i) == '(')
                    count++;

                st.push(s.charAt(i++) + "");
            }

            StringBuilder str = new StringBuilder();

            while(!st.isEmpty() && !st.peek().equals("("))
                str.append(new StringBuilder(st.pop()).reverse());

            if(!st.isEmpty())
                st.pop();

            if(count == 0)
                str.reverse();

            st.push(str.toString());
            count--;
        }

        return st.pop();
    }
}