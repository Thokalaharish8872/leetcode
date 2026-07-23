class Solution {
    public int uniqueXorTriplets(int[] nums) {
        return nums.length <= 2 ? nums.length : 1 << (31 - Integer.numberOfLeadingZeros(nums.length) + 1);
    }
}