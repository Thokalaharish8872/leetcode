// we can solve with hashmap also but the tc is slighlter more because of unboxing and autoboxing and some operations

class Solution {
    public int uniqueXorTriplets(int[] nums) {

        //2048 is the max xor value that can be obtained
        boolean[] pair = new boolean[2048];

        // first cal j, k xor and let res is x
        for(int num1 : nums)
            for(int num2 : nums)
                pair[num1 ^ num2] = true;

        boolean[] ans = new boolean[2048];

        // then cal i, x
        for(int num : nums)
            for(int i = 0; i < 2048; i++)
                if(pair[i])
                    ans[num ^ i] = true;

        int count = 0;

        // find the total valid xor triplets
        for(boolean flag : ans)
            count += flag ? 1 : 0;

        return count;
    }
}