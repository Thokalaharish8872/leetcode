class Solution {

    public int countPrimeSetBits(int left, int right) {

        HashSet<Integer> primes = new HashSet<>(Set.of(2, 3, 5, 7, 11, 13, 17, 19));
        int count = 0;

        while(left <= right){

            int leftSetBits = Integer.bitCount(left);
            int rightSetBits = Integer.bitCount(right);

            if(primes.contains(leftSetBits)) count++;
            if(primes.contains(rightSetBits) && left != right) count++;

            left++;
            right--;
        }
        return count;
    }
}