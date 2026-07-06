class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        boolean[] isRemoved = new boolean[n];
        int removed = 0;

        for(int i = 0; i < n; i++){

            if(!isRemoved[i]){
                for(int j = 0; j < n; j++){
                    if(i == j || isRemoved[j])
                        continue;

                    if(intervals[i][0] <= intervals[j][0] && intervals[i][1] >= intervals[j][1]){
                        isRemoved[j] = true;
                        removed++;
                    }
                }
            }
        }

        return n - removed;
    }
}