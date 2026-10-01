class Solution {
    public boolean isValid(String s) {
        char[] arr = new char[]{'(', ')', '[', ']', '{', '}'};

        Stack<Character> st = new Stack<>();
        st.push('.');

        for(char ch : s.toCharArray()){
            if((ch == arr[1] && st.peek() == arr[0]) || 
                (ch == arr[3] && st.peek() == arr[2]) || 
                (ch == arr[5] && st.peek() == arr[4])
            )
                st.pop();
            else
                st.push(ch);
        }

        return st.size() == 1;
    }
}