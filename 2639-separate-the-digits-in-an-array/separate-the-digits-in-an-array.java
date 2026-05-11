class Solution {
    private void seperate(int num, List<Integer> list){
        if(num <= 0) return;
        seperate(num / 10, list);
        list.add(num % 10);
    }
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            seperate(num, list);
        }

        int n = list.size();
        int[] ans = new int[n];

        for(int i = 0; i < n; i++)
            ans[i] = list.get(i);
        
        return ans;
    }
}