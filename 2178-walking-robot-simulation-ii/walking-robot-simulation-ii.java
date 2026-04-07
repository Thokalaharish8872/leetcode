class Robot {
    int[][] grid;
    String[] dir;

    int currDir;
    int i, j;
    int m, n;
    
    boolean isVisited;

    public Robot(int width, int height) {
        i = 0;
        j = 0;

        dir = new String[]{"South", "East", "North", "West"};
        currDir = 0;

        m = height;
        n = width;

        isVisited = false;
    }
    
    public void step(int num) {
        isVisited = true;

        int perimeter = 2 * (m + n) - 4;
        num = (num % perimeter == 0) ? perimeter : num % perimeter;

        while(num-- != 0){

            if((i == 0 && j == 0) || (i == 0 && j == n - 1) ||
                (i == m -1 && j == 0) || (i == m - 1 && j == n - 1)) currDir = (currDir + 1) % 4;

            if(currDir == 0) i--;
            else if(currDir == 1) j++;
            else if(currDir == 2) i++;
            else if(currDir == 3) j--;
        }
    }
    
    public int[] getPos() {
        return new int[]{j, i};
    }
    
    public String getDir() {
        if(!isVisited) return "East";
        return dir[currDir];
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */