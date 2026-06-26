class Solution {
    class Fenwik{
        int[] bit;

        Fenwik(int n, int offset){
            this.bit = new int[2 * n + 2];
        }

        int query(int idx){
            int sum = 0;

            while(idx > 0){
                sum += bit[idx];
                idx -= idx & -idx;
            }

            return sum;
        }

        void update(int idx){

            while(idx < bit.length){
                bit[idx]++;
                idx += idx & -idx;
            }
        }
    }
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int offset = n + 1;
        long valid = 0;
        int sum = 0;

        Fenwik f = new Fenwik(n, offset);
        f.update(offset);

        for(int num : nums){
            sum += (num == target) ? + 1 : -1;

            valid += f.query(sum + offset - 1);
            f.update(sum + offset);
        }

        return valid;
    }
}