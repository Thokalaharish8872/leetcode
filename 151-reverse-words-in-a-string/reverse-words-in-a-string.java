class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder sp = new StringBuilder();

        for(int i = str.length - 1; i >= 0; i--)
            if(!str[i].isEmpty())
                sp.append(str[i] + " ");
        
        return sp.toString().trim();
    }
}