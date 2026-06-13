class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String[] alp = new String[]{"z", "y", "x", "w", "v", "u", "t",
                                "s", "r", "q", "p", "o", "n", "m", 
                                "l", "k", "j", "i", "h", "g", "f",
                                "e", "d", "c", "b", "a"};
        String map = "";

        for(String word : words){
            int sum = 0;

            for(char ch : word.toCharArray())
                sum += weights[ch - 97];
            
            map = map.concat(alp[sum % 26]);
        }

        return map;
    }
}