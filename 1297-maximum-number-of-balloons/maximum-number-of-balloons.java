class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char t : text.toCharArray()){
            if(t == 'b' || t == 'a' || t == 'l' || t == 'o' || t == 'n')
                map.put(t, map.getOrDefault(t, 0) + 1);
        }

        if(map.size() != 5)
            return 0;

        int minFreq = (int)1e9;
        for(char key : map.keySet()){

            int freq = map.get(key);
            if(key == 'l' || key == 'o')
                freq /= 2;
            
            minFreq = Math.min(minFreq, freq);
        }

        return minFreq;
    }
}