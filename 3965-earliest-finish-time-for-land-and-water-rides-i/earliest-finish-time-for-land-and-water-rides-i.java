class Solution {
    private int findShortestTime(int[] stTime, int[] stDur, int[] endTime, int[] endDur){

        int minTime = Integer.MAX_VALUE;
        
        for(int i = 0; i < stTime.length; i++){
            for(int j = 0; j < endTime.length; j++){

                int totalTime = stTime[i] + stDur[i];
                totalTime = Math.max(totalTime, endTime[j]);
                totalTime += endDur[j];

                minTime = Math.min(minTime, totalTime);
            }
        }

        return minTime;
    }
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
        int[] waterStartTime, int[] waterDuration) {
        
        return Math.min(findShortestTime(landStartTime, landDuration, waterStartTime, waterDuration),
        findShortestTime(waterStartTime, waterDuration, landStartTime, landDuration));
    }
}