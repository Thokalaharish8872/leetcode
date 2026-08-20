class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;

        int[] arr1 = new int[n], arr2 = new int[n];

        arr1[0] = nums[0];
        arr2[0] = nums[1];

        int n1 = 0, n2 = 0;

        for(int i = 2; i < n; i++){
            if(arr1[n1] > arr2[n2])
                arr1[++n1] = nums[i];
            else
                arr2[++n2] = nums[i];
        }

        System.arraycopy(arr2, 0, arr1, n1 + 1, n2 + 1);

        return arr1;
    }
}