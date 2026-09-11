class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length;

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            if(digits[i] == 0)  continue;

            for(int j = 0; j < n; j++){
                if(i == j)  continue;

                for(int k = 0; k < n; k++){
                    if(k == i || k == j || (digits[k] & 1) != 0)  continue;

                    int num = ((((digits[i] * 10) + digits[j]) * 10) + digits[k]); 

                    set.add(num);
                }
            }
        }

        System.out.println(set);

        return set.size();
    }
}