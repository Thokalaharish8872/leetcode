class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();

        for(String domain : cpdomains){
            int idx = domain.indexOf(" ");

            int visits = Integer.parseInt(domain.substring(0, idx));
            String dom = domain.substring(idx + 1);

            map.put(dom, map.getOrDefault(dom, 0) + visits);
            idx = dom.indexOf(".");

            while(idx != -1){

                dom = dom.substring(idx + 1);
                map.put(dom, map.getOrDefault(dom, 0) + visits);
                
                idx = dom.indexOf(".");
            }
        }

        List<String> ans = new ArrayList<>();

        for(String key : map.keySet()){
            int visits = map.get(key);

            ans.add(visits + " " + key);
        }

        return ans;
    }
}