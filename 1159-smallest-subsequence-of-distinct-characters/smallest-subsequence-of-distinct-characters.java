class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        int[] last = new int[26];
        boolean[] vis = new boolean[26];

        for(int i = 0; i < n; i++)
            last[s.charAt(i) - 'a'] = i;

        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < n; i++){

            char curr = s.charAt(i);

            if(vis[curr - 'a'])
                continue;

            while(!st.isEmpty() && st.peek() > curr && last[st.peek() - 'a'] > i){        
                vis[st.pop() - 'a'] = false;
            }

            st.push(curr);
            vis[curr - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty())
            ans.insert(0, st.pop());

        return ans.toString();
    }
}