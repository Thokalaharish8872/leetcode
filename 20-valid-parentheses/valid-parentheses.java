class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();
        st.push('.');

        for(char ch : s.toCharArray()){
            switch(ch){
                case '(' : 
                case '[' :
                case '{' :
                    st.push(ch);
                    break;

                case ')' : if(st.peek() == '(')
                                st.pop();
                            else
                                st.push(')');
                            break;
                    
                case ']' : if(st.peek() == '[')
                                st.pop();
                            else 
                                st.push(']');

                            break;

                case '}' : if(st.peek() == '{')
                                st.pop();
                            else st.push('}');
                            
                            break; 
            }
        }

        return st.size() == 1;
    }
}
