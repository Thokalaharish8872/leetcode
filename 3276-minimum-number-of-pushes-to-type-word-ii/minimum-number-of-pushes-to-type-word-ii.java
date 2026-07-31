class Solution {
    public int minimumPushes(String word) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : word.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        for(char ch : map.keySet())
            pq.add(new int[]{ch - 'a', map.get(ch)});
        
        int clicks = 1;
        int pushes = 0;

        int len = 1;
        
        while(!pq.isEmpty()){
            int m = pq.poll()[1];

            pushes += m * clicks;

            len++;
            if(len == 9){
                clicks++;
                len = 1;
            }
        }

        return pushes;
    }
}