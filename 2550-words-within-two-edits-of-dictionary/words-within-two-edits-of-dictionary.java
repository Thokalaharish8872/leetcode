class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();

        for(String query : queries){
            for(String word : dictionary){

                int diff = 0;
                for(int i = 0 ; i < word.length() && diff <= 2; i++){
                    if(word.charAt(i) != query.charAt(i)) diff++;
                }

                if(diff <= 2){
                    result.add(query);
                    break;
                }
            }
        }

        return result;
    }
}