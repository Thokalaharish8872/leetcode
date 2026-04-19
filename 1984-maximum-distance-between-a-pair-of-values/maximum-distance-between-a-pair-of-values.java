class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {

        int n = nums2.length, m = nums1.length;
        int maxDis = 0;

        for(int j = 0; j < n; j++){
            int l = 0 , r = m - 1, mid;
            int ceil = -1;

            while(l <= r){
                mid = l + (r - l) / 2;

                if(nums1[mid] <= nums2[j]){
                    r = mid - 1;
                    ceil = mid;
                }
                else l = mid + 1;
            }

            if(ceil != -1 && ceil <= j){
                maxDis = Math.max(maxDis, j - ceil);
            }
        }

        return maxDis;
    }
}