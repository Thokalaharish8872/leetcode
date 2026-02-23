class Solution {
    public boolean hasAllCodes(String s, int k) {
        
        HashSet<String> set = new HashSet<>();
        int n = s.length();

        for(int i = 0, j = i + k; j <= n; i++, j++) set.add(s.substring(i, j));
        if(set.size() == (1 << k)) return true;

        return false;
    }
}