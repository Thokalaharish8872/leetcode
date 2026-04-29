class Solution {
    private List<List<Integer>> backtrack(int st, int[] nums, List<Integer> temp, List<List<Integer>> res){
        res.add(new ArrayList<>(temp));

        for(int i = st; i < nums.length; i++){
            temp.add(nums[i]);
            backtrack(i + 1, nums, temp, res);
            temp.remove(temp.size() - 1);
        }

        return res;
    }
    public List<List<Integer>> subsets(int[] nums) {
        return backtrack(0, nums, new ArrayList<>(), new ArrayList<>());
    }
}