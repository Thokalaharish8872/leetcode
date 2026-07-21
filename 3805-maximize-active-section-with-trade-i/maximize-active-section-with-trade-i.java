class Solution {

    // method to extend windows
    private int iterate(String s, int j, int n, char check){
        while(j < n&& s.charAt(j) == check) j++; 
        return j;
    }

    private int getSection(String s, int sectionSt, int n, MaxActiveSection max){

        // extend the windows ('0' 's)
        int activeSt = iterate(s, sectionSt, n, '0');

        // extend the windows ('1' 's)
        int inActiveSt = iterate(s, activeSt, n, '1');

        // extend the windows ('0' 's)
        int sectionEnd = iterate(s, inActiveSt, n, '0');

        // section is invalid
        if(activeSt == n || inActiveSt == n)
            return n;
            
        int sectionSize = sectionEnd - sectionSt;
        int activeBlockSize = inActiveSt - activeSt;

        // update the section
        if(sectionSize - activeBlockSize > max.size - max.activeBlockSize){
            max.size = sectionSize;
            max.activeBlockSize = activeBlockSize;

            max.start = sectionSt;
            max.end = sectionEnd;
        }

        return inActiveSt;
    }

    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();

        // data storage
        MaxActiveSection max = new MaxActiveSection();

        for(int i = 0; i < n; i++)
            if(s.charAt(i) == '0')
                i = getSection(s, i, n, max) - 1;
        
        // totalOnes in the trade
        int totalActiveCount = 0;

        for(int i = 0; i < n; i++){
            if(i == max.start){
                totalActiveCount += max.size;
                i = max.end - 1;
            }
            else if(s.charAt(i) == '1')
                totalActiveCount++;
        }

        return totalActiveCount;
    }
}

class MaxActiveSection{

    int size = 0;
    int start = -1;
    int end = 0;
    int activeBlockSize = 0;
}