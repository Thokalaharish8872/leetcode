class Solution {
    public int[] sortByBits(int[] arr) {
        
        ArrayList<Integer>[] bits = new ArrayList[17];
        int k = 0;

        for(int num : arr){
            int bitCount = Integer.bitCount(num);

            if(bits[bitCount] == null) bits[bitCount] = new ArrayList<>();
            bits[bitCount].add(num);
        }

        for(ArrayList<Integer> bitCount : bits){
            if(bitCount == null) continue;
            
            Collections.sort(bitCount);
            for(int num : bitCount) arr[k++] = num;
        }

        return arr;
        
    }
}