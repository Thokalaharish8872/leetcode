class Solution {
    public double angleClock(int hour, int minutes) {
        if(hour == 12)
            hour = 0;
        
        double hourDegree = (hour * 30) +
                    (minutes == 0 ? 0 : (30.0 / (60.0 / minutes)));
        double minDegree = (minutes * 6);
        double angle = Math.abs(hourDegree - minDegree);
        
        return Math.min(angle, 360 - angle);    }
}