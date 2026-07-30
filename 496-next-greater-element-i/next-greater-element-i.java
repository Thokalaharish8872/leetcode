class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        st.push(-1);

        for(int i = nums2.length - 1; i >= 0; i--){
            map.put(nums2[i], i);

            while(st.size() > 1 && st.peek() < nums2[i])
                st.pop();
            
            int temp = nums2[i];
            nums2[i] = st.peek();
            st.push(temp);
        }

        int[] ans = new int[nums1.length];
        for(int i = 0 ; i < nums1.length; i++)
            ans[i] = nums2[map.get(nums1[i])];

        return ans;
    }
}