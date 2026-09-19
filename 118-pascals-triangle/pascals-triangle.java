class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> dp = new ArrayList<>();

        dp.add(new ArrayList<>(List.of(1)));

        if(numRows <= 1)
            return dp;
            
        dp.add(new ArrayList<>(List.of(1, 1)));

        for(int i = 2; i < numRows; i++){
            dp.add(new ArrayList<>());
            dp.get(i).add(1);

            for(int j = 1; j < i; j++){
                dp.get(i).add(dp.get(i - 1).get(j - 1) + dp.get(i - 1).get(j));
            }

            dp.get(i).add(1);
        }

        return dp;
    }
}