class Solution {
    public String processStr(String s) {
        StringBuilder res = new StringBuilder();

        for(char ch : s.toCharArray()){
            switch(ch){

                case '*' : int n = res.length();
                            if(n == 0)
                                continue;

                            res.deleteCharAt(n - 1);
                            break;
            
                case '#' : res.append(res);
                            break;
                
                case '%' : res.reverse();
                            break;
                
                default : res.append(ch + "");
            }
        }

        return res.toString();
    }
}