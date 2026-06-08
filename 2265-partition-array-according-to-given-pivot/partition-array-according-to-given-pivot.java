class Solution {
    private int add(int[] res, List<Integer> n, int i){
        for(int num : n){
            res[i++] = num;
        }
        return i;
    }
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> n1 = new ArrayList<>();
        List<Integer> n2 = new ArrayList<>();
        List<Integer> n3  = new ArrayList<>();

        for(int num : nums){
            if(num < pivot)
                n1.add(num);
            else if(num == pivot)
                n2.add(num);
            else
                n3.add(num);
        }

        int n = nums.length;
        int[] res = new int[n];

        int i = add(res, n1, 0);
        i = add(res, n2, i);
        add(res, n3, i);

        return res;
    }
}