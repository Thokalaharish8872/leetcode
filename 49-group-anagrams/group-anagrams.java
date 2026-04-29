class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> outer = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);

            String str = new String(ch);

            List<String> inner = map.getOrDefault(str, new ArrayList<>());
            inner.add(s);

            map.put(str, inner);
        }

        for(List<String> inner : map.values()){
            outer.add(inner);
        }

        return outer;
    }
}