class Solution {
    public int countBinarySubstrings(String s) {
        
        char[] arr = s.toCharArray();
        int n = arr.length;
        int prevGroup = 0, currGroup = 1, count = 0;
        
        for(int i = 1; i < n; i++){
            if(arr[i] == arr[i - 1]) currGroup++;
            else{
                count += Math.min(prevGroup, currGroup);

                prevGroup = currGroup;
                currGroup = 1;
            }
        }

        count += Math.min(prevGroup, currGroup);

        return count;
    }
}