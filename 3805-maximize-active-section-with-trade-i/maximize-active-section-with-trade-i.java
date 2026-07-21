class Solution {

    private int iterate(String s, int j, int n, char check){
        while(j < n&& s.charAt(j) == check) j++; 
        return j;
    }

    private int getSectionSize(String s, int sectionSt, int n, MaxActiveSection max){
        int activeSt = iterate(s, sectionSt, n, '0');
        int inActiveSt = iterate(s, activeSt, n, '1');
        int sectionEnd = iterate(s, inActiveSt, n, '0');

        if(activeSt == n || inActiveSt == n)
            return n;
            
        int sectionSize = sectionEnd - sectionSt;
        int activeBlockSize = inActiveSt - activeSt;

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

        MaxActiveSection max = new MaxActiveSection();

        for(int i = 0; i < n; i++)
            if(s.charAt(i) == '0')
                i = getSectionSize(s, i, n, max) - 1;
        
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