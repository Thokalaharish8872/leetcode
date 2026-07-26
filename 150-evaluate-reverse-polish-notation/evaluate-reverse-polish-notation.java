class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String s : tokens){
            try{
                int num = Integer.parseInt(s);
                st.push(num);
            }
            catch(Exception e){
                int op1 = st.pop();
                int op2 = st.pop();

                switch(s){
                    case "*" : st.push(op2 * op1); break;
                    case "/" : st.push(op2 / op1); break;
                    case "+" : st.push(op2 + op1); break;
                    case "-" : st.push(op2 - op1); break;
                }
            }
        }

        return st.pop();
    }
}