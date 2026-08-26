class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        TreeSet<String> set = new TreeSet<>((a, b) -> {
            return a.compareTo(b);
        });

        int minLen = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            while(i < n && s.charAt(i) == '0')
                i++;

            int j = i;
            int oneCount = 0;
            
            while(j < n && oneCount != k){
                if(s.charAt(j) == '1')
                    oneCount++;
                
                j++;
            }

            if(oneCount == k){
                int len = j - i;

                if(len == minLen)
                    set.add(s.substring(i, j));
                else if(len < minLen){

                    minLen = len;
                    set.clear();
                    set.add(s.substring(i, j));
                }
            }
        }

        return set.isEmpty() ? "" : set.first();
    }
}