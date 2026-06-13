class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String map = "";

        for(String word : words){
            int sum = 0;

            for(char ch : word.toCharArray())
                sum += weights[ch - 'a'];
            
            char l = (char)('z' - (sum % 26));
            map = map.concat(l + "");
        }

        return map;
    }
}