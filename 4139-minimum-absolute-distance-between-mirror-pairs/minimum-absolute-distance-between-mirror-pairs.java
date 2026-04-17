class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        int minDis = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i], rev = 0;

            while (num > 0) {
                rev = rev * 10 + (num % 10);
                num /= 10;
            }

            if (map.containsKey(rev)) {
                minDis = Math.min(minDis, map.get(rev) - i);
            }

            map.put(nums[i], i);
        }

        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }
}