class Solution {
    public int fib(int n) {
        if (n == 0)
            return 0;
            
        int n1 = 1;
        int n2 = 0;

        for(int i = 2; i <= n; i++){
            int n3 = n1 + n2;

            n2 = n1;
            n1 = n3;
        }

        return n1;
    }
}