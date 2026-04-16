class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        
        int n = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> dis = new ArrayList<>();

        for(int i = 0; i < n; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for(int i = 0; i < queries.length; i++){
            List<Integer> l = map.get(nums[queries[i]]);
            int m = l.size();

            if(m == 1){
                dis.add(-1);
                continue;
            }

            int pos = Collections.binarySearch(l, queries[i]);

            int prev = l.get((pos - 1 + m) % m);
            int next = l.get((pos + 1) % m);

            int d1 = Math.abs(queries[i] - prev);
            int left = Math.min(d1, n - d1);

            int d2 = Math.abs(queries[i] - next);
            int right = Math.min(d2, n - d2);

            dis.add(Math.min(left, right));
        }

        return dis;
    }
}