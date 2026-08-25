class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean[] a = new boolean[101];

        for(int num : nums)
            a[num] = true;
        
        int multiplicand = k;
        int multiplier = 2;

        while(multiplicand < 101 && a[multiplicand])
            multiplicand = k * multiplier++;

        return multiplicand;
    }
}