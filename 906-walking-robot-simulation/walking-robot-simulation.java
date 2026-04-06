class Solution {
    int maxSq = 0;

    int X = 0, Y = 0;

    private void walk(HashSet<String> obs, char dir, int command){
        while(command-- > 0){

            int nextX = X;
            int nextY = Y;

            if(dir == 'N') nextY++;
            else if(dir == 'E') nextX++;
            else if(dir == 'S') nextY--;
            else if(dir == 'W') nextX--;

            String next = nextX + " " + nextY;

            if(obs.contains(next)){
                break;
            }

            X = nextX;
            Y = nextY;
        }

        int sq = (X * X) + (Y * Y);
        maxSq = Math.max(maxSq, sq);
    }

    private char changeDir(char dir, int command){
        if(command == -1){
            if(dir == 'N') dir = 'E';
            else if(dir == 'E') dir = 'S';
            else if(dir == 'S') dir = 'W';
            else if(dir == 'W') dir = 'N';
        }
        else if(command == -2){
            if(dir == 'N') dir = 'W';
            else if(dir == 'W') dir = 'S';
            else if(dir == 'S') dir = 'E';
            else if(dir == 'E') dir = 'N';
        }

        return dir;
    }
    public int robotSim(int[] commands, int[][] obstacles) {
        
        HashSet<String> obs = new HashSet<>();
        for(int[] obstacle : obstacles){
            obs.add(obstacle[0] + " " + obstacle[1]);
        }

        char dir = 'N';

        for(int command : commands){

            if(command >= 1) walk(obs, dir, command);
            else dir = changeDir(dir, command);

            System.out.println();
        }

        return maxSq;
    }
}