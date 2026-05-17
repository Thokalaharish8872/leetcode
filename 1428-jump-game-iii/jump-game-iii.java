class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;

        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int idx = q.remove();

            if(arr[idx] == 0)
                return true;

            int right = idx + arr[idx];
            int left = idx - arr[idx];

            if(right < n && !vis[right]){
                q.add(right);
                vis[right] = true;
            }
            if(left >= 0 && !vis[left]){
                q.add(left);
                vis[left] = true;
            }
        }

        return false;
    }
}